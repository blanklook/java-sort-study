package com.example;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class InsertSortTest {

	final int START_NUMBER = 1;
	final int END_NUMBER = 10000000;
	private List<Integer> numbers;
	
	@Before
	public void setUp() {
		numbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
		.mapToObj(Integer::valueOf)
		.collect(Collectors.toList());
	}
	@Test
	public void test() {
		assertThat(numbers.get(0), is(START_NUMBER));
		List<Integer> sortedList = insertSort(numbers);
		assertThat(sortedList.size(), is(END_NUMBER));
	}
	
	private List<Integer> insertSort(List<Integer> numbers) {
		List<Integer> sortedList = new LinkedList<>();
		
		originalList :
		for (Integer number : numbers) {
			
			for (int i = 0; i < sortedList.size(); i++) {
				if (number > sortedList.get(i)) {
					sortedList.add(i, number);
					continue originalList;
				}
			}
			
			sortedList.add(sortedList.size(), number);
		}
		
		return sortedList;
	}

}
