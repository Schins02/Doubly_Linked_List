/*  Student information for assignment:
 * 
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Number of slip days I am using:
 */

// Experiment results. CS314 students, place your experiment
// results here:

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class LinkedListTester {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<String>();
        Object[] actual;
        Object[] expected;

        //test 0
        System.out.println("\nTest 0: initial list is empty");
        if( list.toString().equals("[]") )
            System.out.println("Passed test 0");
        else
            System.out.println("Failed test 0");

        //test 0.1
        System.out.println("\nTest 0.1: add to end");
        list.add("A");
        if( list.get(0).equals("A") )
            System.out.println("Passed test 0.1");
        else
            System.out.println("Failed test 0.1");  

        //test 0.2
        System.out.println("\nTest 0.2: size");
        if( list.size() == 1 )
            System.out.println("Passed test 0.2");
        else
            System.out.println("Failed test 0.2"); 

        //test 0.3
        System.out.println("\nTest 0.3: remove from position 0");
        String removed = list.remove(0);
        if(removed.equals("A"))
            System.out.println("Passed test 0.31");
        else
            System.out.println("Failed test 0.31");            

        System.out.println("\nTest 0.31: toStrin after remove");
        //test 0.31
        if( list.toString().equals("[]") )
            System.out.println("Passed test 0.3");
        else
            System.out.println("Failed test 0.3");  

        //test 0.4
        System.out.println("\nTest 0.4: size");
        if( list.size() == 0 )
            System.out.println("Passed test 0.4");
        else
            System.out.println("Failed test 0.4"); 

        //test 0.5
        System.out.println("\nTest 0.5: add and toString");
        list.add("A");
        list.add("B");
        if( list.toString().equals("[A, B]") )
            System.out.println("Passed test 0.5");
        else
            System.out.println("Failed test 0.5");  

        //test 0.6
        System.out.println("\nTest 0.6: size");
        if( list.size() == 2 )
            System.out.println("Passed test 0.6");
        else
            System.out.println("Failed test 0.6");


        //test 1
        System.out.println("\nTest 1: Adding at end");
        list = new LinkedList<String>();
        list.add("A");
        actual = toArray(list);
        expected = new Object[]{"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );		
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 1");
        else
            System.out.println("Failed test 1");


        //test 2
        System.out.println("\nTest 2: making empty");
        list.makeEmpty();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 2");
        else
            System.out.println("Failed test 2");


        //test 3
        System.out.println("\nTest 3: Adding at pos 0 in empty list");
        list.insert(0, "A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  		
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 3");
        else
            System.out.println("Failed test 3");



        //test 4
        System.out.println("\nTest 4: Adding at front");
        list = new LinkedList<String>();
        list.addFirst("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 4");
        else
            System.out.println("Failed test 4");



        //test 5
        System.out.println("\nTest 5: Removing from front");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 5");
        else
            System.out.println("Failed test 5");


        //test 6
        list = new LinkedList<String>();
        System.out.println("\nTest 6: Adding at end");
        list.addLast("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 6");
        else
            System.out.println("Failed test 6");


        //test 7
        System.out.println("\nTest 7: Removing from back");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 7");
        else
            System.out.println("Failed test 7");

        //test 8
        System.out.println("\nTest 8: Adding at middle");
        list = new LinkedList<String>();
        list.add("A");
        list.add("C");
        list.insert(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 8");
        else
            System.out.println("Failed test 8");


        //test 9
        System.out.println("\nTest 9: Setting");
        list = new LinkedList<String>();
        list.add("A");
        list.add("D");
        list.add("C");
        String oldValue = list.set(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 9.1");
        else
            System.out.println("Failed test 9.1");
        if( oldValue.equals("D") )
            System.out.println("Passed test 9.2");
        else
            System.out.println("Failed test 9.2");


        //test 10
        System.out.println("\nTest 10: Removing");
        list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.remove(0);
        list.remove( list.size() - 1 );
        actual = toArray(list);
        expected = new Object[] {"B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 10");
        else
            System.out.println("Failed test 10");
        
        // CS314 Students:
        // uncomment the following line to run tests comparing
        // your LinkedList class to the java ArrayList class.
      // comparison();
        
       //test 11
        
        list.makeEmpty();
        
        System.out.println("\nTest 11: Add to empty list");
        //LinkedList<String> list = new LinkedList<String>();
    	list.add("Gorilla");
    	if(list.get(0).equals("Gorilla"))
    	System.out.println("Passed test 11");
    	else 
    		System.out.println("Failed test 11");
    	
    	//test12
    	
    	System.out.println("\nTest 12: Add to non empty list");
    	list.add("Vs");
    	if(list.get(1).equals("Vs"))
    		System.out.println("Passed test 12");
    	else
    		System.out.println("Failed test 12");
    	
    	//test 13
    	
    	System.out.println("\nTest 13: Final add test");
    	list.add("Bear");
    	if(list.get(2).equals("Bear"))
    		System.out.println("Passed test 13");
    	else
    		System.out.println("Failed test 13");
    	
    	//test 14
    	
     	System.out.println("\nTest 14: Testing toString");
     	String data = "[Gorilla, Vs, Bear]";
    	System.out.println("Expected Result" + data);
    	System.out.println("Actual Result:" + list.toString());
    	if(list.toString().equals(data))
    		System.out.println("Passed test 14");
    		else
    			System.out.println("Failed test 14");
    	
	//test 15
    	
     	System.out.println("\nTest 15: Testing toString");
     	data = "[Gorilla, Vs, Bear, Trout]";
     	list.add("Trout");
    	System.out.println("Expected Result" + data);
    	System.out.println("Actual Result:" + list.toString());
    	if(list.toString().equals(data))
    		System.out.println("Passed test 15");
    		else
    			System.out.println("Failed test 15");
    	
	//test 16
    	
     	System.out.println("\nTest 16: Testing toString");
     	data = "[Gorilla, Vs, Bear, Trout, Sam]";
     	list.add("Sam");
    	System.out.println("Expected Result" + data);
    	System.out.println("Actual Result:" + list.toString());
    	if(list.toString().equals(data))
    		System.out.println("Passed test 16");
    		else
    			System.out.println("Failed test 16");
    	
    	
	//test 17
    	list.removeLast();
    	list.removeLast();
     	System.out.println("\nTest 17: Testing toString");
     	data = "[Gorilla, Vs]";
     	list.removeLast();
    	System.out.println("Expected Result" + data);
    	System.out.println("Actual Result:" + list.toString());
    	if(list.toString().equals(data))
    		System.out.println("Passed test 17");
    		else
    			System.out.println("Failed test 17");
   
    	
  	//test 18
    	
    	System.out.println("\nTest 18: Testing size");
    	int expectedInt = 2;
    	int actualInt = list.size();
    	System.out.println("Expected Result: " + expectedInt);
    	System.out.println("Actual Result: " + actualInt);
    	if(actualInt == expectedInt)
    		System.out.println("Passed test 18");
    		else
    			System.out.println("Failed test 18");
    	
    	//test 19
    	
  	//test 19
    	
    	System.out.println("\nTest 19: Testing size");
    	list.add("Hound");
    	list.add("Dog");
    	expectedInt = 4;
    	actualInt = list.size();
    	System.out.println("Expected Result: " + expectedInt);
    	System.out.println("Actual Result: " + actualInt);
    	if(actualInt == expectedInt)
    		System.out.println("Passed test 19");
    		else
    			System.out.println("Failed test 19");
    	
  	//test 20
    	
    	System.out.println("\nTest 20: Testing size");
    	expectedInt = 3;
    	list.removeLast();
    	list.removeLast();
    	list.add("Bear");
    	actualInt = list.size();
    	System.out.println("Expected Result: " + expectedInt);
    	System.out.println("Actual Result: " + actualInt);
    	if(actualInt == expectedInt)
    		System.out.println("Passed test 20");
    		else
    			System.out.println("Failed test 20");
    	
    	
    	//test 21
    	
    	
    	System.out.println("\n**** ITERATOR TESTS ****");
    	System.out.println("\nTest 21: Testing Iterator's hasNext");
    	Iterator<String> it = list.iterator();
    	boolean test = it.hasNext();
    	if(test == true)
    		System.out.println("Passed test 21"); 
    	else
    		System.out.println("Failed test 21");
    	
    	
    	
    	//test 22
    	
    	System.out.println("\nTest 22: Testing Iterator's next ");
    	data = it.next();
    	if(data.equals("Gorilla"))
    		System.out.println("Passed test 22");
    	else
    		System.out.println("Failed test 22");
    	
    	//test 23
    	
    	System.out.println("\nTest 23: Testing Iterator's remove");
    	it.remove();
    	if(list.size() == 2)
    		System.out.println("Passed test 23");
    	else
    		System.out.println("Falied test 23");
    	
    	//test 24
    	
    	System.out.println("\nTest 24: Testing Iterator's hasNext");
    	test = it.hasNext();
    	if(test == true)
    		System.out.println("Passed test 24");
    	else
    		System.out.println("Failed test 24");
    	
    	//test 25
    	
    	System.out.println("\nTest 25: Testing Iterator's next");
    	data = it.next();
    	if(data.equals("Vs"))
    		System.out.println("Passed test 25");
    	else
    		System.out.println("Failed test 25");
    	
    	//test 26
    	
    	System.out.println("\nTest 26: Testing Iterator's remove");
    	it.remove();
    	if(list.size() == 1)
    		System.out.println("Passed test 26");
    	else
    		System.out.println("Falied test 26");
    	
    	//Test 20
    	
    	System.out.println("\nTest 27: Testing Iterator's next");
    	data = it.next();
    	if(data.equals("Bear"))
    		System.out.println("Passed test 27");
    	else
    		System.out.println("Failed test 27");
    	
    	//test 28
    	
    	System.out.println("\nTest 28: Testing Iterator's remove");
    	it.remove();
    	if(list.size() == 0)
    		System.out.println("Passed test 28");
    	else
    		System.out.println("Falied test 28");
    	
    	//test 29
    	System.out.println("\nTest 29: Testing Iterator's hasNext");
    	test = it.hasNext();
    	if(test == false)
    		System.out.println("Passed test 29");
    	else
    		System.out.println("Failed test 29");
   
    	
    	//test 30
    	list.add("Gorilla");
    	list.add("Vs");
    	list.add("Bear");
    	
    	System.out.println("\nTest 30: Testing toString");
    	data = "[Gorilla, Vs, Bear]";
    	System.out.println("Expected Result" + data);
    	System.out.println("Actual Result:" + list.toString());
    	if(list.toString().equals(data))
    		System.out.println("Passed test 30");
    		else
    			System.out.println("Failed test 30");
    	
    	//test 31
    
    	System.out.println("\nTest 31: Testing size");
    	expectedInt = 3;
    	actualInt = list.size();
    	System.out.println("Expected Result: " + expectedInt);
    	System.out.println("Actual Result: " + actualInt);
    	if(actualInt == expectedInt)
    		System.out.println("Passed test 31");
    		else
    			System.out.println("Failed test 31");
    	
    	//test 32
    
    	System.out.println("\nTest 32: Testing insert at end of list");
    	data = "[Gorilla, Vs, Shark, Bear]";
    	list.insert(list.size()-1, "Shark");
    	String data2 = list.toString();
    	System.out.println("Expected Result: " + data );
    	System.out.println("Actual Result: " + data2);
    	if(data2.equals(data))
    		System.out.println("Passed test 32");
    		else
    			System.out.println("Failed test 32");
    	
    	//test 33
    	
    	System.out.println("\nTest 33: Testing insert in middle of list");
    	data = "[Gorilla, Glue, Vs, Shark, Bear]";
    	list.insert(1, "Glue");
    	data2 = list.toString();
    	System.out.println("Expected Result: " + data );
    	System.out.println("Actual Result: " + data2);
    	if(data2.equals(data))
    		System.out.println("Passed test 33");
    		else
    			System.out.println("Failed test 33");
    	
    	//test 34
    	
    	System.out.println("\nTest 34: Testing insert at front of list");
    	data = "[Crab, Gorilla, Glue, Vs, Shark, Bear]";
    	System.out.println("Expected Result: " + data );
    	list.insert(0, "Crab");
    	data2 = list.toString();
    	System.out.println("Actual Result: " + data2);
    	if(data2.equals(data))
    		System.out.println("Passed test 34");
    		else
    			System.out.println("Failed test 34");
    	
    	//test 35
    	
    	System.out.println("\nTest 35: Testing equals");
    	LinkedList<String> list3 = new LinkedList<String>();
    	list3.add("Crab");
    	list3.add("Gorilla");
    	list3.add("Glue");
    	list3.add("Vs");
    	list3.add("Shark");
    	list3.add("Bear");
    	test = true;
    	boolean test2 = list.equals(list3);
    	System.out.println("Expected Result: " + test);
    	
    	System.out.println("Actual Result: " + test2);
    	if(test == test2)
    		System.out.println("Passed test 35");
    		else
    			System.out.println("Failed test 35");
    	
    	
    	//test 36 
    	
    	System.out.println("\nTest 36: Testing removeFirst");
    	
    	data = list.removeFirst();
    	data2 = "[Gorilla, Glue, Vs, Shark, Bear]";
    	String expected2 = "Crab";
    	expectedInt = 5;
    	String data3 = list.toString();
    	actualInt = list.size();
    	System.out.println("Expected Result: " + data2 + " Size: " + expectedInt +
    			"  Element: " + expected2);
    	System.out.println("Actual Result: " + data3 + "   Size: " + actualInt + 
    	"  Element: " + data);
    	if(expected2.equals(data) && expectedInt == actualInt && data2.equals(data3))
    		System.out.println("Passed test 36");
    		else
    			System.out.println("Failed test 36");
    		
    	//test 37
    	
    	System.out.println("\nTest 37: Testing equals");
    	list3.removeFirst();			//makes the lists equal
    	test = true;
    	test2 = list.equals(list3);
    	System.out.println("Expected Result: " + test);
    	
    	System.out.println("Actual Result: " + test2);
    	if(test == test2)
    		System.out.println("Passed test 37");
    		else
    			System.out.println("Failed test 37");
    	
    	//test 38
    	
    	System.out.println("\nTest 38: Testing removeFirst");
    	
    	data = list.removeFirst();
    	data2 = "[Glue, Vs, Shark, Bear]";
    	expected2 = "Gorilla";
    	expectedInt = 4;
    	data3 = list.toString();
    	actualInt = list.size();
    	System.out.println("Expected Result: " + data2 + " Size: " + expectedInt +
    			"  Element: " + expected2);
    	System.out.println("Actual Result: " + data3 + "   Size: " + actualInt + 
    	"  Element: " + data);
    	if(expected2.equals(data) && expectedInt == actualInt && data2.equals(data3))
    		System.out.println("Passed test 38");
    		else
    			System.out.println("Failed test 38");
    	
    	//test 39
    	
    	System.out.println("\nTest 39: Testing equals");
    	list3.removeFirst();           //makes lists equal
    	test = true;
    	test2 = list.equals(list3);
    	System.out.println("Expected Result: " + test);
    	
    	System.out.println("Actual Result: " + test2);
    	if(test == test2)
    		System.out.println("Passed test 39");
    		else
    			System.out.println("Failed test 39");
    	
    	//test 39
    	
	System.out.println("\nTest 39: Testing removeFirst");
    	
    	data = list.removeFirst();
    	data2 = "[Vs, Shark, Bear]";
    	expected2 = "Glue";
    	expectedInt = 3;
    	data3 = list.toString();
    	actualInt = list.size();
    	System.out.println("Expected Result: " + data2 + " Size: " + expectedInt +
    			"  Element: " + expected2);
    	System.out.println("Actual Result: " + data3 + "   Size: " + actualInt + 
    	"  Element: " + data);
    	if(expected2.equals(data) && expectedInt == actualInt && data2.equals(data3))
    		System.out.println("Passed test 39");
    		else
    			System.out.println("Failed test 39");
    	
System.out.println("\nTest 40: Testing removeLast");
    	
    	data = list.removeLast();
    	data2 = "[Vs, Shark]";
    	expected2 = "Bear";
    	expectedInt = 2;
    	data3 = list.toString();
    	actualInt = list.size();
    	System.out.println("Expected Result: " + data2 + " Size: " + expectedInt +
    			"  Element: " + expected2);
    	System.out.println("Actual Result: " + data3 + "   Size: " + actualInt + 
    	"  Element: " + data);
    	if(expected2.equals(data) && expectedInt == actualInt && data2.equals(data3))
    		System.out.println("Passed test 40");
    		else
    			System.out.println("Failed test 40");
    	
    	//test 41
    	
    	System.out.println("\nTest 41: Testing removeLast");
    	data = list.removeLast();
    	data2 = "[Vs]";
    	expected2 = "Shark";
    	expectedInt = 1;
    	data3 = list.toString();
    	actualInt = list.size();
    	System.out.println("Expected Result: " + data2 + " Size: " + expectedInt +
    			"  Element: " + expected2);
    	System.out.println("Actual Result: " + data3 + "   Size: " + actualInt + 
    	"  Element: " + data);
    	if(expected2.equals(data) && expectedInt == actualInt && data2.equals(data3))
    		System.out.println("Passed test 41");
    		else
    			System.out.println("Failed test 41");
    	
    	//test 42
    	
      	System.out.println("\nTest 42: Testing removeLast");
    	data = list.removeLast();
    	data2 = "[]";
    	expected2 = "Vs";
    	expectedInt = 0;
    	data3 = list.toString();
    	actualInt = list.size();
    	System.out.println("Expected Result: " + data2 + " Size: " + expectedInt +
    			"  Element: " + expected2);
    	System.out.println("Actual Result: " + data3 + "   Size: " + actualInt + 
    	"  Element: " + data);
    	if(expected2.equals(data) && expectedInt == actualInt && data2.equals(data3))
    		System.out.println("Passed test 42");
    		else
    			System.out.println("Failed test 42");
    	
    	//test 42
    	/*
    	System.out.println("\nTest 42: Testing set at pos 0");
    	list.add("Vs");
    	list.set(0, "Gorilla");
    	data2 = "[Gorilla]";
      	expectedInt = 1;
    	data3 = list.toString();
    	actualInt = list.size();
    	System.out.println("Expected Result: " + data2 + " Size: " + expectedInt +
    			"  Element: " + expected2);
    	System.out.println("Actual Result: " + data3 + "   Size: " + actualInt + 
    	"  Element: " + data);
    	if(expected2.equals(data) && expectedInt == actualInt && data2.equals(data3))
    		System.out.println("Passed test 42");
    		else
    			System.out.println("Failed test 42");
    			*/
    	
    	//test 43
    	
    	System.out.println("\nTest 43: Testing set at the front of list");
    	list.add("Vs");
    	data = list.set(0, "Gorilla");
    	data2 = "[Gorilla]";
      	expectedInt = 1;
    	data3 = list.toString();
    	actualInt = list.size();
    	System.out.println("Expected Result: " + data2 + " Size: " + expectedInt +
    			"  Element: " + expected2);
    	System.out.println("Actual Result: " + data3 + "   Size: " + actualInt + 
    	"  Element: " + data);
    	if(expected2.equals(data) && expectedInt == actualInt && data2.equals(data3))
    		System.out.println("Passed test 43");
    		else
    			System.out.println("Failed test 43");
    	
    	//test 44
    	list.makeEmpty();
    	list.add("A");
    	list.add("B");
    	list.add("C");
    	System.out.println("\nTest 44: Testing set in the middle of list");
    	data = list.set(1, "D");
    	data2 = "[A, D, C]";
      	expectedInt = 3;
    	data3 = list.toString();
    	
    	actualInt = list.size();
    	expected2 = "B";
    	System.out.println("Expected Result: " + data2 + " Size: " + expectedInt +
    			"  Element: " + expected2);
    	System.out.println("Actual Result: " + data3 + "   Size: " + actualInt + 
    	"  Element: " + data);
    	if(expected2.equals(data) && expectedInt == actualInt && data2.equals(data3))
    		System.out.println("Passed test 43");
    		else
    			System.out.println("Failed test 43");
    	
    	//test 45
    	System.out.println("\nTest 45: Testing set at the end of list");
    	data = list.set(2, "E");
    	data2 = "[A, D, E]";
      	expectedInt = 3;
    	data3 = list.toString();
    	
    	actualInt = list.size();
    	expected2 = "C";
    	System.out.println("Expected Result: " + data2 + " Size: " + expectedInt +
    			"  Element: " + expected2);
    	System.out.println("Actual Result: " + data3 + "   Size: " + actualInt + 
    	"  Element: " + data);
    	if(expected2.equals(data) && expectedInt == actualInt && data2.equals(data3))
    		System.out.println("Passed test 45");
    		else
    			System.out.println("Failed test 45");
    	
    	//test 46 
    	
    	System.out.println("\nTest 46: Testing getSublist");
    	list.add("F");
    	list.add("G");
    	IList<String> subResult  = list.getSubList(1,4);
    	data = subResult.toString();
    	data2 = "[D, E, F]";
    	System.out.println("Expected Result: " + data2);
    	System.out.println("Actual Result: " + data);
    	if(data2.equals(data))
    		System.out.println("Passed test 46");
    		else
    			System.out.println("Failed test 46");
    	
    	//test 47
    	
    	System.out.println("\nTest 47: Testing getSublist at beginning of list");
    	subResult  = list.getSubList(0,2);
    	data = subResult.toString();
    	data2 = "[A, D]";
    	System.out.println("Expected Result: " + data2);
    	System.out.println("Actual Result: " + data);
    	if(data2.equals(data))
    		System.out.println("Passed test 47");
    		else
    			System.out.println("Failed test 47");
    	
    	//test 48
    	
    	System.out.println("\nTest 48: Testing getSublist at end of list");
    	subResult  = list.getSubList(3,5);
    	data = subResult.toString();
    	data2 = "[F, G]";
    	System.out.println("Expected Result: " + data2);
    	System.out.println("Actual Result: " + data);
    	if(data2.equals(data))
    		System.out.println("Passed test 48");
    		else
    			System.out.println("Failed test 48");

    	//test 49

    	System.out.println("\nTest 49: Testing removeRange from front of list");
    	list.removeRange(0,2);
    	data = list.toString();
    	data2 = "[E, F, G]";
    	System.out.println("Expected Result: " + data2);
    	System.out.println("Actual Result: " + data);
    	if(data2.equals(data))
    		System.out.println("Passed test 49");
    		else
    			System.out.println("Failed test 49");
    
    	
     	//test 50
    	System.out.println("\nTest 50: Testing removeRange in middle list");
    	list.addFirst("B");
    	list.addFirst("A");
    	list.removeRange(2,3);
    	data = list.toString();
    	data2 = "[A, B, F, G]";
    	System.out.println("Expected Result: " + data2);
    	System.out.println("Actual Result: " + data);
    	if(data2.equals(data))
    		System.out.println("Passed test 50");
    		else
    			System.out.println("Failed test 50");
    	
    	//test 51
    	System.out.println("\nTest 51: Testing removeRange at end of list");
    	list.removeRange(3,4);
    	data = list.toString();
    	data2 = "[A, B, F]";
    	System.out.println("Expected Result: " + data2);
    	System.out.println("Actual Result: " + data);
    	if(data2.equals(data))
    		System.out.println("Passed test 51");
    		else
    			System.out.println("Failed test 51");
    	
    	//test 52
    	System.out.println("\nTest 52: Testing removeRange for last two elements");
    	list.removeRange(1,3);
    	data = list.toString();
    	data2 = "[A]";
    	System.out.println("Expected Result: " + data2);
    	System.out.println("Actual Result: " + data);
    	if(data2.equals(data))
    		System.out.println("Passed test 52");
    		else
    			System.out.println("Failed test 52");
    	
    	//test 53
    	System.out.println("\nTest 53: Testing remove that returns boolean");
    	list.add("B");
    	list.add("C");
    	test = list.remove("A");
    	test2 = true;
    	data = list.toString();
    	data2 = "[B, C]";
    	System.out.println("Expected Result: " + test2 + " " + data2);
    	System.out.println("Actual Result: " +test + " " +  data);
    	if(data2.equals(data) && test == test2)
    		System.out.println("Passed test 53");
    		else
    			System.out.println("Failed test 53");
    	
    	//test 54
    	System.out.println("\nTest 54: Testing remove that returns boolean at last pos in list");
    	list.add("D");
    	list.add("E");
    	test = list.remove("E");
    	test2 = true;
    	data = list.toString();
    	data2 = "[B, C, D]";
    	System.out.println("Expected Result: " + test2 + " " + data2);
    	System.out.println("Actual Result: " +test + " " +  data);
    	if(data2.equals(data) && test == test2)
    		System.out.println("Passed test 54");
    		else
    			System.out.println("Failed test 54");
    	
    	
    	//test 55
    	System.out.println("\nTest 55: Testing remove that returns boolean");
    	list.add("F");
    	test = list.remove("D");
    	test2 = true;
    	data = list.toString();
    	data2 = "[B, C, F]";
    	System.out.println("Expected Result: " + test2 + " " + data2);
    	System.out.println("Actual Result: " +test + " " +  data);
    	if(data2.equals(data) && test == test2)
    		System.out.println("Passed test 55");
    		else
    			System.out.println("Failed test 55");
    	
    	
       	
    	//test 56
    	System.out.println("\nTest 56: Testing remove that returns boolean");
    	test = list.remove("C");
    	test2 = true;
    	data = list.toString();
    	data2 = "[B, F]";
    	System.out.println("Expected Result: " + test2 + " " + data2);
    	System.out.println("Actual Result: " +test + " " +  data);
    	if(data2.equals(data) && test == test2)
    		System.out.println("Passed test 56");
    		else
    			System.out.println("Failed test 56");
    	
    	//test 57
    	
    	System.out.println("\nTest 57: Testing remove that returns element");
    	list.add("A");
    	data = list.remove(1);
    	expected2 = "F";
    	data2 = list.toString();
    	data3 = "[B, A]";
    	System.out.println("Expected Result: " + data3 + " expected element: " +  expected2);
    	System.out.println("Actual Result: " + data2 + "   actual element: " +  data);
    	if(data3.equals(data2) && expected2.equals(data))
    		System.out.println("Passed test 57");
    		else
    			System.out.println("Failed test 57");
    	
    	//test 58
    	
    	System.out.println("\nTest 58: Testing remove that returns element");
    	list.add("C");
    	list.add("A");
    	data = list.remove(3);
    	expected2 = "A";
    	data2 = list.toString();
    	data3 = "[B, A, C]";
    	System.out.println("Expected Result: " + data3 + " expected element: " +  expected2);
    	System.out.println("Actual Result: " + data2 + "   actual element: " +  data);
    	if(data3.equals(data2) && expected2.equals(data))
    		System.out.println("Passed test 58");
    		else
    			System.out.println("Failed test 58");
    	
    	//test 59
    	
    	System.out.println("\nTest 59: Testing remove that returns element");
    	list.add("A");
    	list.add("B");
    	list.add("C");
    	data = list.remove(4);
    	expected2 = "B";
    	data2 = list.toString();
    	data3 = "[B, A, C, A, C]";
    	System.out.println("Expected Result: " + data3 + " expected element: " +  expected2);
    	System.out.println("Actual Result: " + data2 + "   actual element: " +  data);
    	if(data3.equals(data2) && expected2.equals(data))
    		System.out.println("Passed test 59");
    		else
    			System.out.println("Failed test 59");
    	
    	//test 60

    	System.out.println("\nTest 60: Testing indexOf that returns first occurence");
    	actualInt = list.indexOf("B");
    	expectedInt = 0;
    	System.out.println("Expected Result: " + expectedInt);
    	System.out.println("Actual Result: " + actualInt);
    	if(expectedInt == actualInt)
    		System.out.println("Passed test 60");
    		else
    			System.out.println("Failed test 60");
    	
    	//test 61

    	System.out.println("\nTest 61: Testing indexOf that returns first occurence");
    	actualInt = list.indexOf("A");
    	expectedInt = 1;
    	System.out.println("Expected Result: " + expectedInt);
    	System.out.println("Actual Result: " + actualInt);
    	if(expectedInt == actualInt)
    		System.out.println("Passed test 61");
    		else
    			System.out.println("Failed test 61");
    	
    	//test 62

    	System.out.println("\nTest 62: Testing indexOf that returns first occurence");
    	actualInt = list.indexOf("C");
    	expectedInt = 2;
    	System.out.println("Expected Result: " + expectedInt);
    	System.out.println("Actual Result: " + actualInt);
    	if(expectedInt == actualInt)
    		System.out.println("Passed test 62");
    		else
    			System.out.println("Failed test 62");
    	
    	//test 63

    	System.out.println("\nTest 63: Testing indexOf that returns pos starting from @param pos");
    	actualInt = list.indexOf("C", 2);
    	expectedInt = 2;
    	System.out.println("Expected Result: " + expectedInt);
    	System.out.println("Actual Result: " + actualInt);
    	if(expectedInt == actualInt)
    		System.out.println("Passed test 63");
    		else
    			System.out.println("Failed test 63");
    	
    	//test 64

    	System.out.println("\nTest 64: Testing indexOf that returns pos starting from @param pos");
    	actualInt = list.indexOf("C", 4);
    	expectedInt = 04;
    	System.out.println("Expected Result: " + expectedInt);
    	System.out.println("Actual Result: " + actualInt);
    	if(expectedInt == actualInt)
    		System.out.println("Passed test 64");
    		else
    			System.out.println("Failed test 64");
    	
    	//test 65

    	System.out.println("\nTest 65: Testing indexOf that returns pos starting from @param pos");
    	actualInt = list.indexOf("A", 0);
    	expectedInt = 01;
    	System.out.println("Expected Result: " + expectedInt);
    	System.out.println("Actual Result: " + actualInt);
    	if(expectedInt == actualInt)
    		System.out.println("Passed test 65");
    		else
    			System.out.println("Failed test 65");
    	
    	//test 66
    	
    	System.out.println("\nTest 65: Testing Iterator consrtuctor, hasNext and next");
    	Iterator<String> i2 = list.iterator();
    	if(i2.hasNext())
    		data = i2.next();
    	 data2 = list.get(0);
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 66");
    		else
    			System.out.println("Failed test 66");
    	
    	//test 67
    	
    	System.out.println("\nTest 67: Testing Iterator consrtuctor, hasNext and next");
    	if(i2.hasNext())
    		data = i2.next();
    	 data2 = list.get(1);
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 67");
    		else
    			System.out.println("Failed test 67");
    
    	
    	//test 68
    	
    	System.out.println("\nTest 68: Testing makeEmpty");
    	list.makeEmpty();
    	data2 = "[]";
    	data = list.toString();
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 68");
    		else
    			System.out.println("Failed test 68");
    	
    	
    	//test 69
    	
    	System.out.println("\nTest 69 Testing makeEmpty");
    	list.add("A");
    	list.add("B");
    	list.makeEmpty();
    	data = list.toString();
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 69");
    		else
    			System.out.println("Failed test 69");
    	
    	//test 70
    	
     	System.out.println("\nTest 70 Testing makeEmpty");
    	list.add("A");
    	list.add("B");
    	list.add("C");
    	list.add("D");
    	list.makeEmpty();
    	data = list.toString();
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 70");
    		else
    			System.out.println("Failed test 70");
    	
    	//test 71
    	
     	System.out.println("\nTest 71 Testing get");
    	list.add("A");
    	list.add("B");
    	list.add("C");
    	list.add("D");
    	data2 = "A";
    	data = list.get(0);
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 71");
    		else
    			System.out.println("Failed test 71");
    	
    	//test 72
    	System.out.println("\nTest 72 Testing get");
    	data2 = "B";
    	data = list.get(1);
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 72");
    		else
    			System.out.println("Failed test 72");
    	
    	//test 73
    	System.out.println("\nTest 73 Testing get");
    	data2 = "C";
    	data = list.get(2);
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 73");
    		else
    			System.out.println("Failed test 73");
    	
    	//test 74
    	
    	System.out.println("\nTest 74 Testing addFirst");
    	data2 = "Q";
    	list.addFirst("Q");
    	data = list.get(0);
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 74");
    		else
    			System.out.println("Failed test 74");
    	
    	//test 75
    	
    	System.out.println("\nTest 75 Testing addFirst");
    	data2 = "R";
    	list.addFirst("R");
    	data = list.get(0);
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 75");
    		else
    			System.out.println("Failed test 75");
    	
    	//test 76
    	
    	System.out.println("\nTest 76 Testing addFirst");
    	data2 = "S";
    	list.addFirst("S");
    	data = list.get(0);
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 76");
    		else
    			System.out.println("Failed test 76");
    	
    	//test 77
    	
    	System.out.println("\nTest 77 Testing addLast");
    	data2 = "U";
    	list.addLast("U");
    	data = list.get(list.size()-1);
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 77");
    		else
    			System.out.println("Failed test 77");
    	
    	//test 78
    	
    	System.out.println("\nTest 78 Testing addLast");
    	data2 = "R";
    	list.addLast("R");
    	data = list.get(list.size()-1);
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 78");
    		else
    			System.out.println("Failed test 78");
    	
    	//test 79
    	System.out.println("\nTest 79 Testing addLast");
    	data2 = "T";
    	list.addLast("T");
    	data = list.get(list.size()-1);
    	System.out.println("Expected Result: " + data2 );
    	System.out.println("Actual Result: " + data);
    	if(data.equals(data2))
    		System.out.println("Passed test 79");
    		else
    			System.out.println("Failed test 79");
    	
    	
    	
    	
}

    	
    	
 
    private static Object[] toArray(LinkedList<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while( it.hasNext() ){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    //pre: none
    private static boolean arraysSame(Object[] one, Object[] two)  {
        boolean same;
        if( one == null || two == null ) {
            same = (one == two);
        }
        else {
            //neither one or two are null
            assert one != null && two != null;
            same = one.length == two.length;
            if( same ) {
                int index = 0;
                while( index < one.length && same ) {
                    same = ( one[index].equals(two[index]) );
                    index++;
                }
            }
        }
        return same;
    }

    // A method to be run to compare the LinkedList you are completing and the Java ArrayList class
    public static void comparison(){
        Stopwatch s = new Stopwatch();
        int initialN = 50000;
        int numTests = 5;


        addEndArrayList(s, initialN, numTests);
        addEndLinkedList(s, initialN, numTests);

        initialN = 10000;
        addFrontArrayList(s, initialN, numTests);
        addFrontLinkedList(s, initialN, numTests);

        removeFrontArrayList(s, initialN, numTests);
        removeFrontLinkedList(s, initialN, numTests);

        getRandomArrayList(s, initialN, numTests);
        getRandomLinkedList(s, initialN, numTests);

        getAllArrayListUsingIterator(s, initialN, numTests);
        getAllLinkedListUsingIterator(s, initialN, numTests);

        getAllArrayListUsingGetMethod(s, initialN, numTests);
        getAllLinkedListUsingGetMethod(s, initialN, numTests);

    }

    // These pairs of method illustarte a failure to use polymorphism
    // If the students had implemented the Java list interface there
    // could be a single method. Also we could use function objects to
    // reduce the awful repitition of code.
    public static void addEndArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Adding at end: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to end of an ArrayList. ");
            s.start();
            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void addEndLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Adding at end: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to end of a LinkedList. ");
            s.start();
            for(int j = 0; j < n; j++)
                studentList.add(j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void addFrontArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Adding at front: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to front of an ArrayList. ");
            s.start();
            for(int j = 0; j < n; j++)
                javaList.add(0, j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void addFrontLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Adding at front: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to front of a LinkedList. ");
            s.start();
            for(int j = 0; j < n; j++)
                studentList.insert(0, j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void removeFrontArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Removing from front: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Removing " + n + " elements from front of an ArrayList. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.start();
            while( !javaList.isEmpty())
                javaList.remove(0);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("removing from front: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Removing " + n + " elements from front of a LinkedList. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);
            s.start();
            while( studentList.size() != 0 )
                studentList.removeFirst();
            s.stop();
            System.out.println("Time to remove: " + s);
            n *= 2;
        }
    }

    public static void getRandomArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Getting random: ArrayList");
        int n = initialN;
        int total = 0;
        Random r = new Random();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting " + n + " elements from random locations in an ArrayList. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.start();
            for(int j = 0; j < n; j++){
                total++;
                javaList.get( r.nextInt(n) );
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getRandomLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Getting random: LinkedList");
        int n = initialN;
        int total = 0;
        Random r = new Random();
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting " + n + " elements from random locations in a LinkedList. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);
            s.start();
            for(int j = 0; j < n; j++){
                total++;
                studentList.get( r.nextInt(n) );
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllArrayListUsingIterator(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Getting all using iterator: ArrayList");
        int n = initialN;
        int total = 0;
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all " + n + " elements from an ArrayList using the iterator. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);

            Iterator<Integer> it = javaList.iterator();
            s.start();
            while( it.hasNext() ){
                total++;
                it.next();
            }        
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllLinkedListUsingIterator(Stopwatch s, int initialN, int numTests){
        System.out.println("Getting all using iterator: LinkedList");
        int n = initialN;
        int total = 0;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all " + n + " elements from LinkedList using the iterator. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);
            Iterator<Integer> it = studentList.iterator();

            s.start();
            while(it.hasNext()){
                total++;
                it.next();
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Getting all using get method: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all " + n + " elements from an ArrayList using the get method. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);

            s.start();
            int x = 0;
            for(int j = 0; j < javaList.size(); j++){
                x += javaList.get(j);
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        System.out.println("Getting all using get method: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all " + n + " elements from LinkedList using get method. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);

            s.start();
            int x = 0;
            for(int j = 0; j < studentList.size(); j++){
                x += studentList.get(j);
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }
    



}