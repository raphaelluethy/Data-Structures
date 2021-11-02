package datastructures.list.linkedlist;

import datastructures.list.linkedlist.general.AbstractMyLinkedListTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class A_MyLinkedListTest_Add extends AbstractMyLinkedListTest {
    @Test
    public void isEmpty_OnEmptyList_True() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void add_Numbers1To5_AllNumbersAdded() {
        Integer[] numbersToAdd = new Integer[]{1, 2, 3, 4, 5};
        addNumbersToList(numbersToAdd);
        checkOrderIndependentOccurrence(numbersToAdd);
    }

    @Test
    public void add_AddDuplicates_AllNumbersAdded() {
        Integer[] numbersToAdd = new Integer[]{1, 2, 3, 3, 2, 1};
        addNumbersToList(numbersToAdd);
        checkOrderIndependentOccurrence(numbersToAdd);
    }
}
