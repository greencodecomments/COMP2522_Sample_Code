package ca.bcit.comp2522.assignments.a4;

import java.util.ArrayList;
import java.util.Iterator;

public class MyCustomArrayList<T> implements Iterable<T> {
    private ArrayList<T> arrayList;

    public MyCustomArrayList() {
        arrayList = new ArrayList<>();
    }

    public void add(T t) {
        arrayList.add(t);
    }


    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < arrayList.size();
            }

            @Override
            public T next() {
                T nextObject = arrayList.get(currentIndex);
                currentIndex++;
                return nextObject;
            }
        };
        return iterator;
    }

    public Iterator<T> reverseIterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private int currentIndex = arrayList.size()-1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public T next() {
                T nextObject = arrayList.get(currentIndex);
                currentIndex--;
                return nextObject;
            }
        };
        return iterator;
    }

}
