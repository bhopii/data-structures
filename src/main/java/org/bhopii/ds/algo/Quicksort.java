package org.bhopii.ds.algo;

public class Quicksort {
	/* low  --> Starting index,  high  --> Ending index */
	public static void quickSort(int[] arr, int low, int high) {
		System.out.println("low = " + low + ", high = " + high);
		if(low < high) {
			int pi = partition(arr, low, high);
	        quickSort(arr, low, pi - 1);  // Before pi
	        quickSort(arr, pi + 1, high); // After pi
		}
	}
	
	
	/**
	 * This function takes last element as pivot, places the pivot element at its correct position in sorted array, 
	 * and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	    
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		System.out.println("pivot = " + pivot);
		int i = (low - 1);
		System.out.println("i  = " + i );
		for(int j=low; j<=high -1; j++) {
			if(arr[j] < pivot) {
				i++;
				swapPosition(arr, i, j);
				System.out.println("After swap in loop partition");
				printArray(arr);
			}
		}
		System.out.println("After loop in partition");
		printArray(arr);
		swapPosition(arr, i+1, high);
		return (i+1);
	}



	private static void swapPosition(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}


	public static void main(String[] args) {
		int arr[] = {10, 80, 30, 90, 40, 50, 70};
		System.out.println("Before sort");
		printArray(arr);
		quickSort(arr, 0, arr.length - 1);
		printArray(arr);
		
	}
	
	private static void printArray(int arr[]) {
		for(int cnt=0; cnt<arr.length; cnt++) {
			System.out.print(arr[cnt] + ", ");
		}
		System.out.println("---Print complete---");
	}
}
