package ca.bcit.comp2522.assignments.a4;

import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        MyCustomArrayList<Integer> ints = new MyCustomArrayList<>();

        ints.add(5);
        ints.add(7);

        for (Integer i : ints) {
            System.out.println("int: "+i);
        }

        for(Iterator<Integer> iter = ints.reverseIterator(); iter.hasNext();) {
            Integer i = iter.next();
            System.out.println("int: "+i);
        }

    }
}
