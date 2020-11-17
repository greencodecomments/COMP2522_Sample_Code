package ca.bcit.comp2522.labs.collectionsLab;

import java.util.ArrayList;
import java.util.Random;

public class RandomSequenceGenerator implements RandomIterable {

    private int initialSize;
    private int remainingSize;
    Random generator = new Random();

    public ArrayList<Integer> remaining = new ArrayList<>();

    public RandomSequenceGenerator(int size) {
        initialSize = size;
        remainingSize = size;
        for (int i = 0; i<size; ++i) {
           remaining.add(i);
        }
    }

    @Override
    public String toString() {
        return remaining.toString() + " ("+remainingSize+"/"+initialSize+")";
    }

    @Override
    public RandomSequenceIterator randomIterator() {
        return new RandomSequenceIterator();
    }

    public class RandomSequenceIterator implements RandomIterator {
        private int currentPosition;

        RandomSequenceIterator() {
            currentPosition = -1;
        }

        public boolean hasNext() {
            return remainingSize > 0;
        }

        public int next() {
            int randomIndex = generator.nextInt(remainingSize);

            int temp = remaining.get(randomIndex);
            remaining.set(randomIndex,remaining.get(remainingSize-1));
            remaining.set(remainingSize-1,temp);

            remainingSize--;

            return temp;
        }

    }

}
