package org.bhopii.ds.arrays;

public class ArrayRotation {

	public static void main(String args[]) {
		int[] arr = { 1, 2, 3, 4, 5 };
		printArray(arr);

		leftRotate(arr, arr.length, 1);
		printArray(arr);
		
		rightRotate(arr, arr.length, 1);
		printArray(arr);
		

	}

	/**
	 * @param arr
	 * @param length
	 * @param i
	 */
	private static void rightRotate(int[] arr, int length, int turns) {
		turns = turns % length;
		// Reverse the whole array
		reverseArray(arr, 0, length - 1);
		// Reverse 0 to turns
		reverseArray(arr, 0, turns - 1);
		// Reverse turns to end
		reverseArray(arr, turns, length - 1);

	}
	
	
	/**
	 * @param arr
	 * @param length
	 * @param i
	 */
	private static void leftRotate(int[] arr, int length, int turns) {
		turns = turns % length;
		// Reverse the whole array = {7,6,5,4,3,2,1}
		reverseArray(arr, 0, length - 1);
		// Reverse length - turns to length - 1 =  {7,6,5,4,3,1,2}
		reverseArray(arr, length - turns, length - 1);
		// Reverse 0 to length - turns - 1 = {3,4,5,6,7,1,2}
		reverseArray(arr, 0, length - turns - 1);

	}

	private static void reverseArray(int[] nums, int start, int end) {
		while (start <= end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	private static void printArray(int[] rotatedArr) {
		for (int element : rotatedArr) {
			System.out.print(element + ",");
		}
		System.out.println("");

	}

}
