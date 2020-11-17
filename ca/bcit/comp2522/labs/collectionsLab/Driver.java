package ca.bcit.comp2522.labs.collectionsLab;


import java.util.*;

public class Driver {
    static final int X_LARGE = 100_000_000;
    static final int LARGE = 1_000_000;

    public static void main(String[] args) {

        System.out.println("Start");

        //testSequenceGenerator();
        testHashSet();
        //testPriorityQueue();

        System.out.println("Done");
    }

    public static void testPriorityQueue() {
        PriorityQueue<NamedNumber> queue = new PriorityQueue<>();
        queue.add(new NamedNumber(1,"One"));
        queue.add(new NamedNumber(2,"Two"));
        queue.add(new NamedNumber(1,"One"));
        queue.add(new NamedNumber(3,"Three"));
        queue.add(new NamedNumber(4,"Four"));
        queue.add(new NamedNumber(3,"Three"));
        System.out.println("Queue: "+queue);
    }

    public static void testHashSet() {
        Integer x = 5;
        Integer y = 6;
        Integer z = 5;

        HashSet<Integer> intSet = new HashSet<>();
        ArrayList<Integer> intList = new ArrayList<>();
        intSet.add(x);
        intSet.add(y);
        intSet.add(z);

        System.out.println("intSet: "+intSet);

        intList.add(x);
        intList.add(y);
        intList.add(z);
        System.out.println("intList: "+intList);

        System.out.println("\n\n");

        HashSet<Point> pointSet = new HashSet<>();
        ArrayList<Point> pointList = new ArrayList<>();

        Point p1 = new Point(1,5);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(1,5);

        pointSet.add(p1);
        pointSet.add(p2);
        pointSet.add(p3);
        System.out.println("PointSet: "+pointSet);

        pointList.add(p1);
        pointList.add(p2);
        pointList.add(p3);
        System.out.println("PointList: "+pointList);

        System.out.println("Does pointSet contain p2? " +pointSet.contains(p2));
        System.out.println("Does pointList contain p2? " +pointList.contains(p2));
        p2.x = 3;
        p2.y = 4;
        System.out.println("Does pointSet contain p2? " +pointSet.contains(p2));
        System.out.println("Does pointList contain p2? " +pointList.contains(p2));
    }

    public static void testSequenceGenerator() {
        long startTime;
        long endTime;
        Interval interval;

        System.out.println("Start");

        startTime = System.nanoTime();
        System.out.println("RandomSequence: "+startTime);

        RandomSequenceGenerator generator = new RandomSequenceGenerator(1_000_000);

        //System.out.println(generator);
        for(RandomIterator iter = generator.randomIterator(); iter.hasNext();) {
            System.out.println("i: "+iter.next());
            //System.out.println(generator);
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("RandomSequence: "+endTime + " duration: "+interval);
    }
}
