package com.example;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {
	final int START_NUMBER = 1;
	final int END_NUMBER = 10000;
	private int[] numbers;
	@Before
	public void setUp() {
		numbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER).toArray();
	}
	
	@Test
	public void test() {
		assertThat(numbers[0], is(START_NUMBER));
		bubbleSort(numbers);
		assertThat(numbers[0], is(END_NUMBER));
	}
	
	private int[] bubbleSort(int[] numbers) {
		boolean numbersSwitched;
		do {
			numbersSwitched = false;
			for (int i = 0; i < numbers.length - 1; i++) {
				if (numbers[i] < numbers[i+1]) {
					int temp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = temp;
					numbersSwitched = true;
				}
			}
		} while (numbersSwitched);
		return numbers;
	}

}
