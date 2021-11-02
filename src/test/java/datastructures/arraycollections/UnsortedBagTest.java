package datastructures.arraycollections;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import datastructures.arraycollections.excercise.AbstractArrayCollection;
import datastructures.arraycollections.mysol.UnsortedBag;
import org.junit.Test;

import datastructures.arraycollections.general.AbstractBagTest;
import datastructures.arraycollections.general.ElementExistenceChecker;

public class UnsortedBagTest extends AbstractBagTest {
	@Override
	protected <T extends Comparable<? super T>> AbstractArrayCollection<T> createCollection(int size) {
		return new UnsortedBag<T>(size);
	}

	@Override
	protected Integer[] getExpectedOrderFor(Integer[] values) {
		return values;
	}

	@Test
	public void testLinearSearch() {
		Integer[] numbers = new Integer[] { 6, 10, 8, 5, 1 };
		addNumbersToBag(numbers);
		assertTrue(bag.contains(1));
	}

	@Override
	protected void checkElementExistence(Comparable<Integer>[] numbers) {
		ElementExistenceChecker.inRandomOrder(Arrays.copyOf(numbers, numbers.length), bag);
	}
}
