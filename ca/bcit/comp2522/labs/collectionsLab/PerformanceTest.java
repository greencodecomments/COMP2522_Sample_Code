package ca.bcit.comp2522.labs.collectionsLab;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PerformanceTest {
    public static final int X_LARGE = 10_000_000;
    public static final int LARGE = 1_000_000;
    public static final int MEDIUM = 100_000;
    public static final int SMALL = 10_000;
    public static final int X_SMALL = 1_000;
    public static final int XXX_SMALL = 10;

    private long startTime;
    private long endTime;
    private Interval interval;

    protected ArrayList<Integer> testArrayList;
    protected LinkedList<Integer> testLinkedList;
    protected PriorityQueue<Integer> testPriorityQueue;
    protected HashSet<Integer> testHashSet;
    protected LinkedHashSet<Integer> testLinkedHashSet;
    protected TreeSet<Integer> testTreeSet;

    protected RandomSequenceGenerator generator;
    protected RandomSequenceGenerator generator2;
    protected RandomSequenceGenerator generator3;
    protected RandomSequenceGenerator generator4;
    protected RandomSequenceGenerator generator5;
    protected RandomSequenceGenerator generator6;


    @Before
    public void setUp() throws Exception {
        testArrayList = new ArrayList<>();
        testLinkedList = new LinkedList<>();
        testPriorityQueue = new PriorityQueue<>();
        testHashSet = new HashSet<>();
        testLinkedHashSet = new LinkedHashSet<>();
        testTreeSet = new TreeSet<>();
    }

    @After
    public void tearDown() throws Exception {
        testArrayList = null;
    }

    public void buildCollections(int size) {
        //for (int i = 0; i<size; ++i) {
        for (int i = size-1; i >= 0; --i) {
            testArrayList.add(i);
            testLinkedList.add(i);
            testPriorityQueue.add(i);
            testHashSet.add(i);
            testLinkedHashSet.add(i);
            testTreeSet.add(i);
        }
    }

    public void buildCollectionsRandomOrder(int size) {
        RandomSequenceGenerator generator = new RandomSequenceGenerator(size);

        for(RandomIterator iter = generator.randomIterator(); iter.hasNext();) {
            int i = iter.next();
            testArrayList.add(i);
            testLinkedList.add(i);
            testPriorityQueue.add(i);
            testHashSet.add(i);
            testLinkedHashSet.add(i);
            testTreeSet.add(i);
        }
    }

    public void buildSequenceGenerators(int size) {
        generator = new RandomSequenceGenerator(size);
        generator2 = new RandomSequenceGenerator(size);
        generator3 = new RandomSequenceGenerator(size);
        generator4 = new RandomSequenceGenerator(size);
        generator5 = new RandomSequenceGenerator(size);
        generator6 = new RandomSequenceGenerator(size);
    }

    @Test
    public void showIterationOrder() {
        String[] numberNames = {"One","Two","Three","Four","Five"};

        ArrayList<NamedNumber> testArrayList = new ArrayList<>() ;
        LinkedList<NamedNumber> testLinkedList = new LinkedList<>();
        PriorityQueue<NamedNumber> testPriorityQueue = new PriorityQueue<>();
        HashSet<NamedNumber> testHashSet = new HashSet<>();
        LinkedHashSet<NamedNumber> testLinkedHashSet = new LinkedHashSet<>();
        TreeSet<NamedNumber> testTreeSet = new TreeSet<>();

        for (int i=numberNames.length-1; i>=0; --i) {
            NamedNumber n = new NamedNumber(i,numberNames[i]);
            testArrayList.add(n);
            testLinkedList.add(n);
            testPriorityQueue.add(n);
            testHashSet.add(n);
            testLinkedHashSet.add(n);
            testTreeSet.add(n);
        }

        System.out.println("ArrayList: "+testArrayList);
        System.out.println("LinkedList: "+testLinkedList);
        System.out.println("PriorityQueue: "+testPriorityQueue);
        System.out.println("HashSet: "+testHashSet);
        System.out.println("LinkedHashSet: "+testLinkedHashSet);
        System.out.println("TreeSet: "+testTreeSet);
    }

    @Test
    public void testRandomAccess() {
        final int size = MEDIUM;
        buildCollections(size);
        buildSequenceGenerators(size);

        //ArrayList
        startTime = System.nanoTime();
        System.out.println("ArrayList Start: "+startTime);

        for(RandomIterator iter = generator2.randomIterator(); iter.hasNext();) {
            //System.out.println(testArrayList.get(iter.next()));
            testArrayList.get(iter.next());
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("ArrayList End: "+endTime + " duration: "+interval + "\n");

        //LinkedList
        startTime = System.nanoTime();
        System.out.println("LinkedList Start: "+startTime);


        for(RandomIterator iter = generator.randomIterator(); iter.hasNext();) {
            //System.out.println(testLinkedList.get(iter.next()));
            testLinkedList.get(iter.next());
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("LinkedList End: "+endTime + " duration: "+interval + "\n");
    }

    @Test
    public void testFindItem() {
        final int size = MEDIUM;
        buildCollections(size);
        buildSequenceGenerators(size);

        //ArrayList
        startTime = System.nanoTime();
        System.out.println("ArrayList Start: "+startTime);


        for(RandomIterator iter = generator.randomIterator(); iter.hasNext();) {
            //System.out.println(testArrayList.get(iter.next()));
            testArrayList.contains(iter.next());
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("ArrayList End: "+endTime + " duration: "+interval + "\n");

        //LinkedList
        startTime = System.nanoTime();
        System.out.println("LinkedList Start: "+startTime);


        for(RandomIterator iter = generator2.randomIterator(); iter.hasNext();) {
            //System.out.println(testLinkedList.get(iter.next()));
            testLinkedList.contains(iter.next());
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("LinkedList End: "+endTime + " duration: "+interval + "\n");

        //PriorityQueue
        startTime = System.nanoTime();
        System.out.println("PriorityQueue Start: "+startTime);


        for(RandomIterator iter = generator3.randomIterator(); iter.hasNext();) {
            //System.out.println(testLinkedList.get(iter.next()));
            testPriorityQueue.contains(iter.next());
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("PriorityQueue End: "+endTime + " duration: "+interval + "\n");

        //HashSet
        startTime = System.nanoTime();
        System.out.println("HashSet Start: "+startTime);


        for(RandomIterator iter = generator4.randomIterator(); iter.hasNext();) {
            //System.out.println(testLinkedList.get(iter.next()));
            testHashSet.contains(iter.next());
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("HashSet End: "+endTime + " duration: "+interval + "\n");


        //LinkedHashSet
        startTime = System.nanoTime();
        System.out.println("LinkedHashSet Start: "+startTime);


        for(RandomIterator iter = generator5.randomIterator(); iter.hasNext();) {
            //System.out.println(testLinkedList.get(iter.next()));
            testLinkedHashSet.contains(iter.next());
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("LinkedHashSet End: "+endTime + " duration: "+interval + "\n");

        //TreeSet
        startTime = System.nanoTime();
        System.out.println("TreeSet Start: "+startTime);


        for(RandomIterator iter = generator6.randomIterator(); iter.hasNext();) {
            //System.out.println(testLinkedList.get(iter.next()));
            testTreeSet.contains(iter.next());
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("TreeSet End: "+endTime + " duration: "+interval + "\n");
    }

    @Test
    public void testRemoveSpecific() {
        final int size = MEDIUM;
        buildCollections(size);
        buildSequenceGenerators(size);

        //ArrayList
        startTime = System.nanoTime();
        System.out.println("ArrayList Start: "+startTime);


        for(RandomIterator iter = generator.randomIterator(); iter.hasNext();) {
            testArrayList.remove(Integer.valueOf(iter.next()));
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("ArrayList End: "+endTime + " duration: "+interval + "\n");

        //LinkedList
        startTime = System.nanoTime();
        System.out.println("LinkedList Start: "+startTime);


        for(RandomIterator iter = generator2.randomIterator(); iter.hasNext();) {
            testLinkedList.remove(Integer.valueOf(iter.next()));
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("LinkedList End: "+endTime + " duration: "+interval + "\n");

        //PriorityQueue
        startTime = System.nanoTime();
        System.out.println("PriorityQueue Start: "+startTime);

        for(RandomIterator iter = generator3.randomIterator(); iter.hasNext();) {
            testPriorityQueue.remove(Integer.valueOf(iter.next()));
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("PriorityQueue End: "+endTime + " duration: "+interval + "\n");

        //HashSet
        startTime = System.nanoTime();
        System.out.println("HashSet Start: "+startTime);


        for(RandomIterator iter = generator4.randomIterator(); iter.hasNext();) {
            testHashSet.remove(Integer.valueOf(iter.next()));
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("HashSet End: "+endTime + " duration: "+interval + "\n");


        //LinkedHashSet
        startTime = System.nanoTime();
        System.out.println("LinkedHashSet Start: "+startTime);


        for(RandomIterator iter = generator5.randomIterator(); iter.hasNext();) {
            testLinkedHashSet.remove(Integer.valueOf(iter.next()));
        }


        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("LinkedHashSet End: "+endTime + " duration: "+interval + "\n");

        //TreeSet
        startTime = System.nanoTime();
        System.out.println("TreeSet Start: "+startTime);


        for(RandomIterator iter = generator.randomIterator(); iter.hasNext();) {
            testTreeSet.remove(Integer.valueOf(iter.next()));
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("TreeSet End: "+endTime + " duration: "+interval + "\n");
    }


    @Test
    public void testInsertionSpeed() {
        //ArrayList
        startTime = System.nanoTime();
        System.out.println("ArrayList Start (insert at end): "+startTime);

        for (int i = 0; i < X_LARGE; ++i) {
            testArrayList.add(i);
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("ArrayList End: "+endTime + " duration: "+interval + "\n");

        //ArrayList
        startTime = System.nanoTime();
        System.out.println("ArrayList Start (insert at front) - ONLY X_SMALL! : "+startTime);

        for (int i = 0; i < X_SMALL; ++i) {
            testArrayList.add(0,i);
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("ArrayList End: "+endTime + " duration: "+interval + "\n");


        //LinkedList
        startTime = System.nanoTime();
        System.out.println("LinkedList Start (insert at end): "+startTime);

        for (int i = 0; i < X_LARGE; ++i) {
            testLinkedList.add(i);
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("LinkedList End: "+endTime + " duration: "+interval + "\n");


        //LinkedList
        startTime = System.nanoTime();
        System.out.println("LinkedList Start (insert at front): "+startTime);

        for (int i = 0; i < X_LARGE; ++i) {
            testLinkedList.add(0,i);
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("LinkedList End: "+endTime + " duration: "+interval + "\n");

        //PriorityQueue
        startTime = System.nanoTime();
        System.out.println("PriorityQueue Start: "+startTime);

        for (int i = 0; i < X_LARGE; ++i) {
            testPriorityQueue.add(i);
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("PriorityQueue End: "+endTime + " duration: "+interval + "\n");

        //HashSet
        startTime = System.nanoTime();
        System.out.println("HashSet Start: "+startTime);

        for (int i = 0; i < X_LARGE; ++i) {
            testHashSet.add(i);
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("HashSet End: "+endTime + " duration: "+interval + "\n");

        //LinkedHashSet
        startTime = System.nanoTime();
        System.out.println("LinkedHashSet Start: "+startTime);

        for (int i = 0; i < X_LARGE; ++i) {
            testLinkedHashSet.add(i);
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("LinkedHashSet End: "+endTime + " duration: "+interval + "\n");

        //TreeSet
        startTime = System.nanoTime();
        System.out.println("TreeSet Start: "+startTime);

        for (int i = 0; i < X_LARGE; ++i) {
            testTreeSet.add(i);
        }

        endTime = System.nanoTime();
        interval = new Interval(endTime - startTime);

        System.out.println("TreeSet End: "+endTime + " duration: "+interval + "\n");

        //Always pass the 'test'
        assertTrue(true);
    }

}
