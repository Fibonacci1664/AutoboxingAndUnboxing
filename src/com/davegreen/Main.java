package com.davegreen;

import java.util.ArrayList;

class IntClass                                                        // This is basically what is known as a wrapper, i have wrapped all of the functionality
{                                                                     // of the field myInt in a class called IntClass for the purposes of using an int in an
    private int myInt;                                                // ArrayList.
    
    public IntClass(int myInt)
    {
        this.myInt = myInt;
    }
    
    public int getMyInt()
    {
        return myInt;
    }
    
    public void setMyInt(int myInt)
    {
        this.myInt = myInt;
    }
}

class TestBox
{
    Integer i = 0;                                                  // A small exercise to show that you must instantiate any and ALL class objects including those that are the
    int j;                                                          // counterparts to their primitive types, else we end up with a null pointer exception, due to trying to
                                                                    // access the i variable which unlike its primitive counterpart does not have an assigned default value.
    public void go()
    {
        j = i;
        System.out.println(j);
        System.out.println(i);
    }
}

public class Main
{
    
    public static void main(String[] args)
    {
        String[] stringArray = new String[10];                          // This is a normal string array with 10 elements.
        int[] intArray = new int[10];                                   // This is a normal int array with 10 elements.
        
        ArrayList<String> stringArrayList = new ArrayList<String>();        // This is a normal ArrayList of type String.
        stringArrayList.add("Dave");                                    // This is how we would add to the type String ArrayList.
        
        //ArrayList<int> intArrayList = new ArrayList<int>();             // This is NOT LEGAL!, as you can only pass CLASSES to to ArrayList, not primitive types, String is a class remember.
        
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();      // This is perfectly legal as we have now passed a class within the diamond.
        
        intClassArrayList.add(new IntClass(54));                    // This is how we COULD (not necessarily should) create an ArrayList of type int even though int is primitive.
                                                                        // We have managed to add an element to the ArrayList that stores the value 54, we managed this by creating a
                                                                        // new IntClass object as the object we wished to add and then using that to pass the value of 54 in the
                                                                        // constructor when the object is created.
    
        System.out.println("########################");
       
        ArrayList listOfNumbers = new ArrayList();                      // There is an alternative way to wrap primitives, first we create the array list that will hold the values.
        listOfNumbers.add(new Integer(3));                        // Then we add a new Integer class object to the array, passing the value of 3 to its constructor, very similar to the
                                                                        // above example but instead of having to create our own class to serve their purpose there is one already pre built
                                                                        // in the Java API called "Integer", we have at this point added the primitive int value of 3 to an array list.
    
    
    
    
    
        Integer one = (Integer) listOfNumbers.get(0);                   // Here we create a variable called "one" and assign it to the value the is at element zero in the array list, this will
                                                                        // by default return us an Object unless we explicitly cast it back to an Integer.
        int intOne = one.intValue();                                    // Here we finally unwrap the primitive int value out of the Integer class wrapper it was inside, setting it the the
                                                                        // variable name intOne.
        System.out.println(intOne);                                     // Print out the original int value that was passed to the Integer constructor when adding the original value to the
                                                                        // array list.
        System.out.println("########################");
    
        
    
                                                                        // Instead of all this we should really be using Autoboxing.
        
        Integer integer = new Integer(54);                           // Instead of using self made wrappers etc Java has built in wrappers for ALL its primitive types for the exact
                                                                        // purpose of using amongst other things in ArrayLists, here we see Integer which is the wrapper class for int.
        
        Double myDouble = new Double(12.25);                         // Here we see the wrapper for double type.
        
        ArrayList<Integer> myIntegerArrayList= new ArrayList<Integer>();   // Here it can be see that we get no errors in declaring an ArrayList of type Integer, and we have not had to
                                                                            // go through the process of creating our own class to use as a wrapper for a primitive type.
        
        for(int i = 0; i <= 10; i ++)
        {
            myIntegerArrayList.add(Integer.valueOf(i));                    // This line here is the actual Autoboxing (Process of converting a primitive type to a class type)
                                                                            // of primitive type int to the Object wrapper class Integer.
            
            System.out.println(i + " -> " + myIntegerArrayList.get(i).intValue());      // This line is the actual Unboxing (Process of converting an Object wrapper class type and changing
                                                                                        // it back into a primitive type) of the Object wrapper class Integer back into the primitive type int.
        }
        
        
        Integer myIntValue = 56;        // This is the quicker way to write the same thing.
                                        // You dont have to actually write "new" and create the object as this      // This is the quick Autoboxing process.
                                        // happens automatically at compile time: Integer.valueOf(56).
        
        int myInt = myIntValue;         // This is actually whats happening here: myIntValue.IntValue();
                                        // Or more fully shown it would look like this: int myInt = myIntValue.intValue();      // This is the quick Unboxing process.
        
        
        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        
        for(double dbl = 0.0; dbl <= 10.0; dbl += 0.5)
        {
            myDoubleValues.add(Double.valueOf(dbl));            // This is the Autoboxing process. (Changing a primitive type double to a Class Double in order that it can be stored in the ArrayList).
        }
        
        for(int i = 0; i < myDoubleValues.size(); i ++)
        {
            double value = myDoubleValues.get(i).doubleValue(); // This is the Unboxing process. (Changing a Class Double back to a primitive type double in order that it can be retrieved from the ArrayList).
            System.out.println(i + " --> " + value);
        }
    
        System.out.println("### -------------------- ###");
        
        TestBox t = new TestBox();
        t.go();
    
        System.out.println("### -------------------- ###");
    }
}
