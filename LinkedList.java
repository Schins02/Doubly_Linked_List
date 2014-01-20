/*  
		John Schindler - Data Structures Spring 2012
 */

import java.util.Iterator;


public class LinkedList<E> implements IList<E> {

	private DoubleListNode<E> first;
	private DoubleListNode<E> last;
	private int size;

	private class LLIterator implements Iterator<E>{
		private DoubleListNode<E> nextNode;
		private boolean removeOk;
		private int posToRemove;


		//public LinkedList()
		//pre: none
		//post: an iterator is constructed
		//O(1)
		private LLIterator() {
			nextNode = first;
			removeOk = false;
			posToRemove = -1;
		}

		//pre: none
		//post:returns true if the iterator is pointing at a non null node
		//O(1)
		public boolean hasNext(){
			return nextNode != null;
		}


		//pre: none
		//post: returns the data in the nextNode, removeOk = true, posToRemove = posToRemove + 1
		//O(1)
		public E next(){
			E data = nextNode.getData();
			nextNode = nextNode.getNext();
			removeOk = true;
			posToRemove++;
			return data;
		}


		//pre: none
		//post: the element at posToRemove is removed
		//O(1)
		public void remove(){
			if(removeOk)
				if(posToRemove == 0)
					removeFirst();
				else if(posToRemove == size - 1)
					removeLast();
				else{
					nextNode.getPrev().getPrev().setNext(nextNode);
					nextNode.setPrev(nextNode.getPrev().getPrev());
					size--;
				}
			removeOk = false;
			posToRemove--;


		}
	}
	
        		
        		
	 /**
     * Add an item to the end of this list.
     * <br>pre: item != null
     * <br>post: size() = old size() + 1, get(size() - 1) = item
     * @param item the data to be added to the end of this list
     * O(1)
     */
	public void add(E item){
		if(item.equals(null))
			throw new IllegalArgumentException("item != null");
			
		//if(size == 0)
			//addFirst(item);
		//else
			addLast(item);
	}


	/**
	 * Insert an item at a specified position in the list.
	 * <br>pre: 0 <= pos <= size(), item != null
	 * <br>post: size() = old size() + 1, get(pos) = item, all elements in
	 * the list with a positon >= pos have a position = old position + 1
	 * @param pos the position to insert the data at in the list
	 * @param item the data to add to the list
	 * O(N)  
	 */
	public void insert(int pos, E item){
		if(pos < 0 || pos > size || item.equals(null))
			throw new IllegalArgumentException("0 <= pos <= size(), item != null");

		DoubleListNode<E> tempNode = new DoubleListNode<E>(null, item, null);
		if(pos == 0){
			addFirst(item);
		}
		else if(pos == size){
			addLast(item);
		}
		else{
			int middle = size/2;
			if(pos > middle)
				insertBackHalf(pos,tempNode);
			else
				insertFrontHalf(pos, tempNode);
		}
	}
	
	
	/**
	 * Insert helper method called if pos <= middle of list
	 * <br>pre: pos!= null, tempNode != null
	 * <br>post: tempNode is inserted at pos. All elements in
     * the list with a position >= pos have a position = old position + 1
	 * The method starts traversing from the first element
	 * @param pos the position to insert the data at in the list
	 * @param tempNode the node to insert to the list
	 * O(N)
	 */
	private void insertFrontHalf(int pos, DoubleListNode<E> tempNode){

		tempNode.setNext(first.getNext());
		for(int i = 1; i < pos; i++)
			tempNode.setNext(tempNode.getNext().getNext());

		tempNode.setPrev(tempNode.getNext().getPrev());
		tempNode.getPrev().setNext(tempNode);
		tempNode.getNext().setPrev(tempNode);

		size++;
	}
	
	
	/**
	 * Insert helper method called if pos > middle of list
	 * <br>pre: pos!= null, tempNode != null
	 * <br>post: tempNode is inserted at pos. All elements in
	 * the list with a position >= pos have a position = old position + 1
	 * The method starts traversing from the first element
	 * @param pos the position to insert the data at in the list
	 * @param tempNode the node to insert to the list
	 * O(N)
	 */  
	private void insertBackHalf(int pos, DoubleListNode<E> tempNode){

		tempNode.setPrev(last.getPrev());
		for(int i = size - 2; i >= pos; i--)
			tempNode.setPrev(tempNode.getPrev().getPrev());

		tempNode.setNext(tempNode.getPrev().getNext());
		tempNode.getNext().setPrev(tempNode);
		tempNode.getPrev().setNext(tempNode);

		size++;
	}
	

	 /**
     * Change the data at the specified position in the list.
     * the old data at that position is returned.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: get(pos) = item, return the
     * old get(pos)
     * @param pos the position in the list to overwrite  
     * @param item the new item that will overwrite the old item
     * @return the old data at the specified position
     * O(N)
     */
	public E set(int pos, E item){
		if(pos < 0 || pos >= size || item.equals(null))
			throw new IllegalArgumentException("0 <= pos < size(), item != null ");
		
		E data;
		if(pos == 0){
			data = first.getData();
			first.setData(item);
			return data;
		}
		else if(pos == size-1){
			data = last.getData();
			last.setData(item);
			return data;
		}
		else{
			DoubleListNode<E> tempNode = first.getNext();

			for(int i = 1; i < pos; i++)
				tempNode = tempNode.getNext();

			data = tempNode.getData();
			tempNode.setData(item);
			return data;
		}
	}
	
	
	/**
     * Get an element from the list.
     * <br>pre: 0 <= pos < size()
     * <br>post: return the item at pos
     * @param pos specifies which element to get
     * @return the element at the specified position in the list
     * O(N)
     */
	public E get(int pos){
		if(pos < 0 || pos >= size)
			throw new IllegalArgumentException("0 <= pos < size()");
		
		int middle = size/2;
		if(pos > middle)
			return getBackHalf(pos);
		else{
			DoubleListNode<E> tempNode = first;

		for(int i = 0; i < pos; i++)
			tempNode = tempNode.getNext();

		return tempNode.getData();
		}
	}
	
	
	/**
     * Helper method for get if pos > middle of list
     * <br>pre: 0 <= pos < size()
     * <br>post: return the item at pos
     * @param pos specifies which element to get
     * @return the element at the specified position in the list
     * O(N)
     */
	private E getBackHalf(int pos){

		DoubleListNode<E> tempNode = last;
		
		for(int i = size-1; i > pos; i--)
			tempNode = tempNode.getPrev();

		return tempNode.getData();
	}
	
	
	/**
     * Remove an element in the list based on position.
     * <br>pre: 0 <= pos < size()
     * <br>post: size() = old size() - 1, all elements of
     * list with a positon > pos have a position = old position - 1
     * @param pos the position of the element to remove from the list
     * @return the data at position pos
     */
	public E remove(int pos){
		if(pos < 0 || pos >= size)
			throw new IllegalArgumentException("0 <= pos < size()");

		if(pos == 0){
			return removeFirst();
		} 
		if(pos == size-1){
			return removeLast();
		}
		int middle = size/2;
		
		if(pos > middle)
			return removeBackHalf(pos);
		else{
			DoubleListNode<E> tempNode = first.getNext();

			for(int i = 1; i < pos; i++)
				tempNode = tempNode.getNext();

			tempNode.getNext().setPrev(tempNode.getPrev());
			tempNode.getPrev().setNext(tempNode.getNext());
			size--;
			return tempNode.getData();
		}
}
	
	/**
     * Helper method for remove called if pos > middle of list.
     * <br>pre: 0 <= pos < size()
     * <br>post: size() = old size() - 1, all elements of
     * list with a positon > pos have a position = old position - 1
     * @param pos the position of the element to remove from the list
     * @return the data at position pos
     * O(N)
     */
	private E removeBackHalf(int pos){

		DoubleListNode<E> tempNode = last.getPrev();
		for(int i = size-2; i > pos; i--)
			tempNode = tempNode.getPrev();


		tempNode.getNext().setPrev(tempNode.getPrev());
		tempNode.getPrev().setNext(tempNode.getNext());
		size--;
		return tempNode.getData();
	}
	


	/**
	 * Remove the first occurrence of obj in this list.
	 * Return <tt>true</tt> if this list changed as a result of this call, <tt>false</tt> otherwise.
	 * <br>pre: obj != null
	 * <br>post: if obj is in this list the first occurence has been removed and size() = old size() - 1. 
	 * If obj is not present the list is not altered in any way.
	 * @param obj The item to remove from this list.
	 * @return Return <tt>true</tt> if this list changed as a result of this call, <tt>false</tt> otherwise.
	 * O(N)
	 */
	public boolean remove(E obj){
		if(obj.equals(null))
			throw new IllegalArgumentException("obj != null");

		if(first.getData().equals(obj)){
			removeFirst();
			return true;
		}
		else{
			DoubleListNode<E> tempNode = first.getNext();
			for(int i = 1; i <= size-1; i++){
				if(tempNode.getData().equals(obj)){
					if(i == size - 1){
						last = tempNode.getPrev();
						last.setNext(null);
					}
					else{
						tempNode.getPrev().setNext(tempNode.getNext());
						tempNode.getNext().setPrev(tempNode.getPrev());
					}
					size--;
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		return false;
	}
	
	
	/**
	 * Return a sublist of elements in this list from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
	 * This list is not changed as a result of this call.
	 * <br>pre: <tt>0 <= start < size(), start <= stop <= size()</tt>
	 * <br>post: return a list whose size is stop - start and contains the elements at positions start through stop - 1 in this list.
	 * @param start index of the first element of the sublist.
	 * @param stop stop - 1 is the index of the last element of the sublist.
	 * @return a list with <tt>stop - start</tt> elements, The elements are from positions <tt>start</tt> inclusive to
	 * <tt>stop</tt> exclusive in this list.
	 * O(N)
	 */
	public IList<E> getSubList(int start, int stop){ 
		if(start < 0 || start >= size || start > stop || stop > size)
			throw new IllegalArgumentException("0 <= start < size(), start <= stop <= size()");

		IList <E> subList = new LinkedList<E>();
		DoubleListNode<E> tempNode;
		int pos = 0;
		for(tempNode = first; tempNode != null; tempNode = tempNode.getNext()) {
			if (pos >= start && pos < stop) {
				subList.add(tempNode.getData());
			}
			else if (pos > stop)
				break;
			++pos;
		}
		return subList;
	}
		

	/**
     * Return the size of this list. In other words the number of elements in this list.
     * <br>pre: none
     * <br>post: return the number of items in this list
     * @return the number of items in this list
     * O(1)
     */
	public int size(){
		return size;
	}

   
	/**
	 * Find the position of an element in the list.
	 * <br>pre: item != null
	 * <br>post: return the index of the first element equal to item
	 * or -1 if item is not present
	 * @param item the element to search for in the list
	 * @return return the index of the first element equal to item or a -1 if item is not present
	 * O(N)
	 */
	public int indexOf(E item){
		if(item.equals(null))
			throw new IllegalArgumentException("item != null");

		DoubleListNode<E> tempNode = first;
		for(int i = 0; i < size; i++)
		{
			if(tempNode.getData().equals(item))
				return i;
			tempNode = tempNode.getNext();
		}
		return -1;
	}

	
	 /**
     * find the position of an element in the list starting at a specified position.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: return the index of the first element equal to item starting at pos
     * or -1 if item is not present from position pos onward
     * @param item the element to search for in the list
     * @param pos the position in the list to start searching from
     * @return starting from the specified position return the index of the first element equal to item or a -1 if item is not present between pos and the end of the list
     * O(N)
     */
	public int indexOf(E item, int pos){
		if(item.equals(null) || pos < 0 || pos >= size)
			throw new IllegalArgumentException("item may not be null," +
					" 0 <= pod < size ");
		DoubleListNode<E> tempNode = first;
		for(int i = 0 ; i < pos; i++){
			tempNode = tempNode.getNext();
		}
		for(int i = pos; i < size; i++){
			if(tempNode.getData().equals(item))
				return i;
			tempNode = tempNode.getNext();
		}
		return -1;
	}

	 /**
     * return the list to an empty state.
     * <br>pre: none
     * <br>post: size() = 0
     * O(1)
     */
	public void makeEmpty(){
		 first = last = null;
	     size = 0;

	}


    /**
    * return an Iterator for this list.
    * <br>pre: none
    * <br>post: return an Iterator object for this List
    * O(1)
    */
	public Iterator<E> iterator(){
		return new LLIterator();
	}
	
	
	  /**
     * Remove all elements in this list from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
     * <br>pre: <tt>0 <= start < size(), start <= stop <= size()</tt>
     * <br>post: <tt>size() = old size() - (stop - start)</tt>
     * @param start position at beginning of range of elements to be removed
     * @param stop stop - 1 is the position at the end of the range of elements to be removed
     * O(N)
     */
	public void removeRange(int start, int stop){
		if(start < 0 || start == size || stop < start || start > size || stop > size) 
			throw new IllegalArgumentException("0 <= start < size(), start <= stop <= size()");

		if(start == 0){
			for(int i = 0; i < stop; i++){
				removeFirst();
			}
		}
		else{ 
			DoubleListNode<E> frontOfRange = first.getNext();
			for(int i = 1; i < start; i++){
				frontOfRange = frontOfRange.getNext();
			}
			
			DoubleListNode<E> endOfRange = frontOfRange;
			for(int i = start; i < stop; i++){
				endOfRange = endOfRange.getNext();
				size--;
			}
			if( stop == size + (stop - start) )
				last = frontOfRange.getPrev();
			else{
				frontOfRange.getPrev().setNext(endOfRange);
				endOfRange.setPrev(frontOfRange.getPrev());
			}
		}

	}
	
	/**
	 * add item to the front of the list.
	 * <br>pre: item != null
	 * <br>post: size() = old size() + 1, get(0) = item
	 * @param item the data to add to the front of this list
	 */
    public void addFirst(E item){
    	if(item.equals(null)) throw new IllegalArgumentException("item != null");

    	if(size == 0){
    		first = new DoubleListNode<E>(null, item, null);
    		last = first;
    	}
    	else{
    		DoubleListNode<E> newNode = new DoubleListNode<E>(null, item, first );
    		first.setPrev(newNode);
    		first = newNode;
    	}
    	size++;
    }


	/**
	 * add item to the end of the list.
	 * <br>pre: item != null
	 * <br>post: size() = old size() + 1, get(size() -1) = item
	 * @param item the data to add to the end of this list
	 */
	public void addLast(E item){
		if(item.equals(null)) throw new IllegalArgumentException("item != null");
		if(size == 0)
			addFirst(item);
		else{
		DoubleListNode<E> tempNode = new DoubleListNode<E>(last, item, null);
		last.setNext(tempNode);
		last = tempNode;
		size++;
		}
	}
	


	/**
	 * remove and return the first element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old first element of this list
	 */
	public E removeFirst(){	
		if(size == 0)
			throw new IllegalArgumentException("size > 0");
		
		E data = first.getData();
		if(size > 1){
		first.getNext().setPrev(null);
		first = first.getNext();
		size--;
		}
		else
			makeEmpty();
		
		
		return data;
	}


	/**
	 * remove and return the last element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old last element of this list
	 */
	public E removeLast(){	
		if(size == 0)
			throw new IllegalArgumentException("size > 0");
		
		E data = last.getData();
		if(size > 1){
		last.getPrev().setNext(null);
		last = last.getPrev();
		size--; 
		}
		else
			makeEmpty();

		return data;
	}

	//pre: none
	//post: a string representation of the LinkedList is returned
	//O(N)
	public String toString(){
		StringBuilder build = new StringBuilder("[");
		if(size > 0){
	    build.append(first.getData());
		DoubleListNode<E> newNode = first.getNext();
	    for(int i = 1; i < size-1; i++)
	    {
	    	build.append(", " + newNode.getData());
	    	newNode = newNode.getNext();
	    }
	    if(size > 1)
	    build.append(", " + newNode.getData());
		}
	    build.append("]");
	    return build.toString();
	}


	/**
	 * check if this list is equal to another Object.
	 * <br>pre: none
	 * @return true if other is a non null LinkedList object
	 * with the same elements as this LinkedList in the same
	 * order.
	 * O(N)
	 */
	public boolean equals(Object other){
		boolean equal = false;
		if(other instanceof LinkedList){
			LinkedList<E> otherList = (LinkedList<E>) other;
			equal = otherList.size == size;
			if(equal && size > 0){
				DoubleListNode<E> thisListNode = new DoubleListNode<E>(null, null, first);
				DoubleListNode<E>otherListNode = new DoubleListNode<E>(null, null, otherList.first);

				int index = 0;
				while(equal && index < size){
					equal = thisListNode.getNext().getData().equals(otherListNode.getNext().getData());
					thisListNode.setNext(thisListNode.getNext().getNext());
					otherListNode.setNext(otherListNode.getNext().getNext());
					index++;
				}
				
			}
		}
		return equal;
	}
	
}

