package ca.bcit.comp2522.assignments.a4;


import ca.bcit.comp2522.a4.ArraySet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


/**
 * JUnit tests for ArraySet
 *
 * @author BCIT
 * @version 1.2
 */
public class ArraySetTest {

    private static final String TEST_VERSION = "V1.2";

    /**
     * Many (anything more tha  n this takes too long).
     */
    public static final int LARGE = 100_000;

    /**
     * Some (seems like a good number).
     */
    public static final int MEDIUM = 1_000;

    /**
     * Few (seems like a good number).
     */
    public static final int SMALL = 10;

    /**
     * Test object.
     */
    protected ArraySet<Integer> testArraySet;

    protected ArraySet<Integer> otherArraySet = new ArraySet<>();

    public Random random = new Random();

    /**
     * @throws Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        testArraySet = new ArraySet<Integer>();
        otherArraySet = new ArraySet<Integer>();
    }

    /**
     * @throws Exception
     */
    @AfterEach
    public void tearDown() throws Exception {
        testArraySet = null;
    }


    @Test
    public void testArraySet() {
        //assertTrue(testArraySet instanceof ArraySet);
    }

    @Test
    public void testEmptySetSizeOfZero() {
        assertTrue(testArraySet.size() == 0);
        assertTrue(testArraySet.isEmpty());
    }

    @Test
    public void testAddOneToEmptySetReturnsTrue() {
        assertTrue(testArraySet.isEmpty());
        int numberToAdd = 1;
        boolean result = testArraySet.add(numberToAdd);
        assertTrue(result);
        assertTrue(testArraySet.size() == 1);
        assertFalse(testArraySet.isEmpty());
    }

    @Test
    public void testAddOneRemoveSameOne() {
        assertTrue(testArraySet.isEmpty());
        int numberToAdd = 1;
        boolean addResult = testArraySet.add(numberToAdd);
        assertTrue(addResult);
        assertTrue(testArraySet.size() == 1);
        assertFalse(testArraySet.isEmpty());

        boolean removeResult = testArraySet.remove(numberToAdd);
        assertTrue(removeResult);
        assertTrue(testArraySet.size() == 0);
        assertTrue(testArraySet.isEmpty());
    }


    @Test
    public void testAddOneRemoveDifferentOne() {
        assertTrue(testArraySet.isEmpty());
        int numberToAdd = 1;
        boolean addResult = testArraySet.add(numberToAdd);
        assertTrue(addResult);
        assertTrue(testArraySet.size() == 1);
        assertFalse(testArraySet.isEmpty());

        int numberToRemove = 2;
        boolean removeResult = testArraySet.remove(numberToRemove);
        assertFalse(removeResult);
        assertTrue(testArraySet.size() == 1);
        assertFalse(testArraySet.isEmpty());
    }

    @Test
    public void testAddManyToEmptySetNoDuplicatesReturnsTrue() {
        boolean result = true;
        for (int i = 0; i < LARGE; ++i) {
            result = result && testArraySet.add(i);
        }
        assertTrue(result);
        assertTrue(testArraySet.size() == LARGE);
        assertFalse(testArraySet.isEmpty());
    }

    @Test
    public void testAddNullToEmptySetThrowsIAException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                testArraySet.add(null));
        assertTrue(testArraySet.size() == 0);
        assertTrue(testArraySet.isEmpty());
    }

    @Test
    public void testContainsReturnsTrueSetOfOne() {
        int numberToAdd = 1;
        boolean result = testArraySet.add(numberToAdd);
        assertTrue(testArraySet.contains(numberToAdd));
        assertTrue(testArraySet.size() == 1);
        assertFalse(testArraySet.isEmpty());

    }

    @Test
    public void testContainsReturnsTrueLargeSet() {
        boolean result = true;
        for (int i = 0; i < LARGE; ++i) {
            testArraySet.add(i);
        }
        for (int i = 0; i < LARGE; ++i) {
            result = result && testArraySet.contains(i);
        }
        assertTrue(result);
        assertTrue(testArraySet.size() == LARGE);

    }

    @Test
    public void testContainsNoNullsEmptySet() {
        assertFalse(testArraySet.contains(null));
        assertTrue(testArraySet.isEmpty());
    }

    @Test
    public void testContainsReturnsFalseForEmptySet() {
        assertFalse(testArraySet.contains(1));
        assertFalse(testArraySet.contains(0));
        assertTrue(testArraySet.isEmpty());
    }

    @Test
    public void testContainsReturnsFalseForSomethingNotInLargeSet() {
        for (int i = 0; i < LARGE; ++i) {
            testArraySet.add(i);
        }
        assertTrue(testArraySet.size() == LARGE);
        assertFalse(testArraySet.contains(LARGE));
    }

    @Test
    public void testContainsNoNullsNonemptySet() {
        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }
        assertTrue(testArraySet.size() == MEDIUM);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            testArraySet.add(null));

        assertFalse(testArraySet.contains(null));
        assertTrue(testArraySet.size() == MEDIUM);
    }

    @Test
    public void testSizeEmptySet() {

        assertEquals(testArraySet.size(), 0);
    }

    @Test
    public void testSizeSmallSet() {

        for (int i = 0; i < SMALL; ++i) {
            testArraySet.add(i);
        }
        assertEquals(testArraySet.size(), SMALL);
    }

    @Test
    public void testSizeMediumSet() {

        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }
        assertEquals(testArraySet.size(), MEDIUM);
    }

    @Test
    public void testSizeLargeSet() {

        for (int i = 0; i < LARGE; ++i) {
            testArraySet.add(i);
        }
        assertEquals(testArraySet.size(), LARGE);
    }

    @Test
    public void testClearEmptySet() {

        testArraySet.clear();
        assertEquals(testArraySet.size(), 0);
    }

    @Test
    public void testClearLargeSet() {

        for (int i = 0; i < LARGE; ++i) {
            testArraySet.add(i);
        }
        testArraySet.clear();
        assertEquals(testArraySet.size(), 0);
    }

    @Test
    public void testClearAndRemove() {

        for (int i = 0; i < SMALL; ++i) {
            testArraySet.add(i);
        }
        testArraySet.clear();
        assertEquals(testArraySet.size(), 0);

        int numberToRemove = 2;
        boolean removeResult = testArraySet.remove(numberToRemove);
        assertFalse(removeResult);
        assertTrue(testArraySet.size() == 0);

    }


    @Test
    public void testAddOneDuplicateSequentiallySmallSet() {

        assertTrue(testArraySet.add(1));
        assertFalse(testArraySet.add(1));
        assertEquals(testArraySet.size(), 1);
    }

    @Test
    public void testAddOneDuplicateNonsequentuallySmallSet() {

        assertTrue(testArraySet.add(1));
        assertTrue(testArraySet.add(2));
        assertFalse(testArraySet.add(1));
        assertEquals(testArraySet.size(), 2);
    }

    @Test
    public void testAddOneRemoveOneAddOneDuplicateTest() {

        assertTrue(testArraySet.add(1));
        assertTrue(testArraySet.add(2));
        assertEquals(testArraySet.size(), 2);

        //try to add 1 again - should fail
        assertFalse(testArraySet.add(1));
        assertEquals(testArraySet.size(), 2);

        //remove 1 - should succeed
        assertTrue(testArraySet.remove(1));
        assertEquals(testArraySet.size(), 1);

        //add 1 back - should succeed
        assertTrue(testArraySet.add(1));
        assertEquals(testArraySet.size(), 2);

        //add 1 again - should fail
        assertFalse(testArraySet.add(1));
        assertEquals(testArraySet.size(), 2);
    }

    @Test
    public void testAddOneDuplicateSequentiallyLargeSet() {

        for (int i = 0; i < LARGE; ++i) {
            testArraySet.add(i);
        }
        for (int i = 0; i < LARGE; ++i) {
            assertFalse(testArraySet.add(i));
        }
        assertEquals(testArraySet.size(), LARGE);

    }

    @Test
    public void testAddManyDuplicatesNonSequentiallyLargeSet() {

        Random random = new Random();
        for (int i = 0; i < LARGE; ++i) {
            testArraySet.add(random.nextInt(SMALL));
        }
        assertEquals(SMALL, testArraySet.size());

    }

    @Test
    public void testToArraySmall() {
        for (int i = 0; i < SMALL; ++i) {
            testArraySet.add(i);
        }
        Object[] arr = testArraySet.toArray();
        assertEquals(arr.length, SMALL);
        for (int i = 0; i < SMALL; ++i) {
            assertNotNull(arr[i]);
            assertTrue(testArraySet.contains((Integer) arr[i]));
        }
    }

    @Test
    public void testToArraySmallCleared() {
        for (int i = 0; i < SMALL; ++i) {
            testArraySet.add(i);
        }
        testArraySet.clear();
        Object[] arr = testArraySet.toArray();
        assertEquals(0, arr.length);
    }

    @Test
    public void testToArrayMediumSomeRemoved() {

        Random random = new Random();

        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }

        int removed = 0;

        for (int i = 0; i < SMALL; ++i) {
            if (testArraySet.remove(random.nextInt(MEDIUM))) {
                removed++;
            }
        }
        Object[] arr = testArraySet.toArray();
        assertEquals(arr.length, (MEDIUM - removed));
    }

    @Test
    public void testIteratorIsNotNull() {

        Iterator<Integer> itr = testArraySet.iterator();
        assertNotNull(itr);
    }

    @Test
    public void testIteratorOverEmptySet() {

        Iterator<Integer> itr = testArraySet.iterator();
        assertTrue(testArraySet.isEmpty());
        int count = 0;
        if (itr.hasNext()) {
            count++;
        }
        assertEquals(count, 0);
    }

    @Test
    public void testIteratorOverMediumSet() {

        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }

        int removed = 0;

        for (int i = 0; i < SMALL; ++i) {
            if (testArraySet.remove(random.nextInt(MEDIUM))) {
                removed++;
            }
        }

        Iterator<Integer> itr = testArraySet.iterator();
        int count = 0;
        while (itr.hasNext()) {
            int i = itr.next();
            count++;
        }
        assertEquals(count, MEDIUM - removed);
    }

    @Test
    public void testRemoveNullFromEmptySet() {

        assertFalse(testArraySet.remove(null));
        assertTrue(testArraySet.size() == 0);

    }

    @Test
    public void testRemoveFromEmptySet() {

        assertFalse(testArraySet.remove(SMALL));
        assertTrue(testArraySet.size() == 0);

    }

    @Test
    public void testRemoveNullFromNonemptySet() {

        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }
        assertFalse(testArraySet.remove(null));
        assertTrue(testArraySet.size() == MEDIUM);

    }

    @Test
    public void testRemoveFirstElementFromNonemptySet() {

        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }
        assertTrue(testArraySet.remove(0));
        assertTrue(testArraySet.size() == (MEDIUM - 1));
        assertFalse(testArraySet.contains(0));
    }

    @Test
    public void testRemoveLastElementFromNonemptySet() {

        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }
        assertTrue(testArraySet.remove((MEDIUM - 1)));
        assertTrue(testArraySet.size() == (MEDIUM - 1));
        assertFalse(testArraySet.contains((MEDIUM - 1)));

    }

    @Test
    public void testRemoveMiddleElementFromNonemptySet() {

        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }
        assertTrue(testArraySet.remove((MEDIUM / 2)));
        assertTrue(testArraySet.size() == (MEDIUM - 1));
        assertFalse(testArraySet.contains((MEDIUM / 2)));

    }

    @Test
    public void testRemoveOneByOneElementsFromNonemptySet() {
        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }
        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.remove(i);
        }
        assertTrue(testArraySet.size() == 0);
        boolean contains = false;
        for (int i = 0; i < MEDIUM; ++i) {
            contains = contains || testArraySet.contains(i);
        }
        assertFalse(contains);
    }

    @Test
    public void testRemoveAllElementsFromNonemptySetAllGone() {
        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }

        for (int i = MEDIUM+SMALL; i >= 0; --i) {
            otherArraySet.add(i);
        }

        testArraySet.removeAll(otherArraySet);

        assertTrue(testArraySet.size() == 0);
        boolean contains = false;
        for (int i = 0; i < MEDIUM; ++i) {
            contains = contains || testArraySet.contains(i);
        }
        assertFalse(contains);
    }


    @Test
    public void testRemoveAllElementsFromNonemptySetSomeLeft() {
        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }

        for (int i = SMALL-1; i >= 0; --i) {
            otherArraySet.add(i);
        }

        testArraySet.removeAll(otherArraySet);
        int newSize = testArraySet.size();

        assertTrue(testArraySet.size() == MEDIUM-SMALL);
        boolean contains = false;
        for (int i = 0; i < SMALL; ++i) {
            contains = contains || testArraySet.contains(i);
        }
        assertFalse(contains);

        boolean contains2 = true;
        for (int i = SMALL; i < MEDIUM; ++i) {
            contains2 = contains2 && testArraySet.contains(i);
        }
        assertTrue(contains2);
    }

    @Test
    public void testContainsAllSmallInMedium() {
        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }

        for (int i = SMALL-1; i >= 0; --i) {
            otherArraySet.add(i);
        }

        testArraySet.retainAll(otherArraySet);

        assertTrue(testArraySet.containsAll(otherArraySet));
    }

    @Test
    public void testContainsAllMediumInMedium() {
        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }

        for (int i = MEDIUM-1; i >= 0; --i) {
            otherArraySet.add(i);
        }

        testArraySet.retainAll(otherArraySet);

        assertTrue(testArraySet.containsAll(otherArraySet));
    }


    @Test
    public void testContainsAllMediumInSmall() {
        for (int i = 0; i < SMALL; ++i) {
            testArraySet.add(i);
        }

        for (int i = MEDIUM-1; i >= 0; --i) {
            otherArraySet.add(i);
        }

        testArraySet.retainAll(otherArraySet);

        assertFalse(testArraySet.containsAll(otherArraySet));
    }



    @Test
    public void testContainsAllSmallInSmallWithRemovals() {
        for (int i = 0; i < SMALL; ++i) {
            testArraySet.add(i);
        }

        testArraySet.remove(random.nextInt(SMALL));

        for (int i = SMALL-1; i >= 0; --i) {
            otherArraySet.add(i);
        }

        testArraySet.retainAll(otherArraySet);

        assertFalse(testArraySet.containsAll(otherArraySet));
    }


    @Test
    public void testContainsAllSmallWithRemovalsInSmall() {
        for (int i = 0; i < SMALL; ++i) {
            testArraySet.add(i);
        }

        for (int i = SMALL-1; i >= 0; --i) {
            otherArraySet.add(i);
        }

        otherArraySet.remove(random.nextInt(SMALL));

        testArraySet.retainAll(otherArraySet);

        assertTrue(testArraySet.containsAll(otherArraySet));
    }

    @Test
    public void testRetainAllElementsFromNonemptySet() {
        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }

        for (int i = SMALL-1; i >= 0; --i) {
            otherArraySet.add(i);
        }

        for (int i = 0; i < SMALL; ++i) {
            int r = random.nextInt(LARGE)+SMALL;
            otherArraySet.add(i);
        }

        testArraySet.retainAll(otherArraySet);

        assertTrue(testArraySet.size() == SMALL);
        boolean contains = true;
        for (int i = 0; i < SMALL; ++i) {
            contains = contains && testArraySet.contains(i);
        }
        assertTrue(contains);
    }

    @Test
    public void testRetainAllElementsFromNonemptySetNonMatching() {
        for (int i = 0; i < SMALL; ++i) {
            testArraySet.add(i);
        }

        for (int i = SMALL; i < SMALL+SMALL; ++i) {
            otherArraySet.add(i);
        }

        testArraySet.retainAll(otherArraySet);

        assertTrue(testArraySet.size() == 0);
        assertTrue(testArraySet.isEmpty());

        boolean contains = false;
        for (int i = 0; i < SMALL+SMALL; ++i) {
            contains = contains || testArraySet.contains(i);
        }
        assertFalse(contains);
    }



    @Test
    public void testAddAllEqualSizes() {
        for (int i = 0; i < SMALL; ++i) {
            testArraySet.add(i);
        }

        for (int i = SMALL; i < (SMALL+SMALL); ++i) {
            otherArraySet.add(i);
        }

        testArraySet.addAll(otherArraySet);

        assertTrue(testArraySet.size() == SMALL+SMALL);

        boolean contains = true;
        for (int i = 0; i < SMALL+SMALL; ++i) {
            contains = contains && testArraySet.contains(i);
        }
        assertTrue(contains);
    }

    @Test
    public void testAddAllEqualSizesWithOverlap() {
        for (int i = 0; i < SMALL; ++i) {
            testArraySet.add(i);
        }

        for (int i = 0; i < SMALL; ++i) {
            otherArraySet.add(i);
        }

        testArraySet.addAll(otherArraySet);

        assertTrue(testArraySet.size() == SMALL);

        boolean contains = true;
        for (int i = 0; i < SMALL; ++i) {
            contains = contains && testArraySet.contains(i);
        }
        assertTrue(contains);
    }

    @Test
    public void testAddAllAddLarger() {
        for (int i = 0; i < SMALL; ++i) {
            testArraySet.add(i);
        }

        for (int i = SMALL; i < (SMALL+MEDIUM); ++i) {
            otherArraySet.add(i);
        }

        testArraySet.addAll(otherArraySet);

        assertTrue(testArraySet.size() == SMALL+MEDIUM);

        boolean contains = true;
        for (int i = 0; i < SMALL+MEDIUM; ++i) {
            contains = contains && testArraySet.contains(i);
        }
        assertTrue(contains);
    }


    @Test
    public void testAddAllAddSmaller() {
        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }

        for (int i = MEDIUM; i < (SMALL+MEDIUM); ++i) {
            otherArraySet.add(i);
        }

        testArraySet.addAll(otherArraySet);

        assertTrue(testArraySet.size() == SMALL+MEDIUM);

        boolean contains = true;
        for (int i = 0; i < SMALL+MEDIUM; ++i) {
            contains = contains && testArraySet.contains(i);
        }
        assertTrue(contains);
    }

    @Test
    public void testToArrayGenerics() {
        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }

        Integer[] ints = new Integer[MEDIUM];

        ints = testArraySet.toArray(ints);

        assertTrue(ints.length == MEDIUM);

        for (int i = 0; i < MEDIUM; ++i) {
            assertTrue(testArraySet.contains(ints[i]));
        }
    }


    @Test
    public void testToArrayGenericsWithRemovals() {
        for (int i = 0; i < MEDIUM; ++i) {
            testArraySet.add(i);
        }

        ArrayList<Integer> removeThese = new ArrayList<>();
        removeThese.add(1);
        removeThese.add(5);

        testArraySet.removeAll(removeThese);

        Integer[] ints = new Integer[MEDIUM-removeThese.size()];

        ints = testArraySet.toArray(ints);

        assertTrue(ints.length == MEDIUM-removeThese.size());

        for (int i = 0; i < MEDIUM-removeThese.size(); ++i) {
            if (!removeThese.contains(i)) {
                assertTrue(testArraySet.contains(ints[i]));
            }
        }
    }

}
