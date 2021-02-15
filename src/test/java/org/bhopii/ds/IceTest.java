package org.bhopii.ds;

import org.junit.jupiter.api.Test;

public class IceTest {
	
	@Test
	public void test1() {
		int x[] = new int[25];
		printArray(x);
	}

	public void printArray(int[] arr) {
		for(int i =0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
