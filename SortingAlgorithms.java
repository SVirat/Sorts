/**
 * Practice for most of the major sorting algorithms.
 * @author Virat Singh, svirat@gmail.com
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class SortingAlgorithms {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		boolean repeat = true;

		while(repeat) {

			int[] array = readArray();

			System.out.println("Choose a sort: ");
			System.out.println("0. Exit");
			System.out.println("1. Bubble sort");
			System.out.println("2. Selection sort");
			System.out.println("3. Insertion sort");
			System.out.println("4. Merge sort");
			System.out.println("5. Quick sort");

			printArray(array);

			try {

				int choice = input.nextInt();
				if(choice == 0) {
					repeat = false;
				}
				else if(choice == 1) { 
					bubbleSort(array);
				}
				else if(choice == 2) { 
					selectionSort(array);
				}
				else if(choice == 3) { 
					insertionSort(array);
				}
				else if(choice == 4) { 
					mergeSort(array, 0, array.length - 1);
				}
				else if(choice == 5) {
					quickSort(array, 0, array.length - 1);
				}
			}catch(InputMismatchException e) {
				System.out.println("Invalid input.");
			}
		}
		input.close();
	}

	/**
	 * Implementing the bubble sort. This has a time complexity of O(n^2).
	 * 
	 * @param array the array to be sorted
	 */
	private static void bubbleSort(int [] array) {
		int size = array.length;
		for(int i = size; i >= 0; i--) {
			for(int j = 0; j < size - 1; j++) {
				if(array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					printArray(array);
				}
			}
		}
	}

	/**
	 * Implementing the selection sort. This has a time complexity of O(n^2).
	 * 
	 * @param array the array to be sorted
	 */
	private static void selectionSort(int [] array) {
		for(int i = 0; i < array.length - 1; i++) {
			int index = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[index]) {
					index = j;
				}
				swap(array, index, i);
				printArray(array);
			}
		}
	}

	/**
	 * Implementing the insertion sort. This has a time complexity of O(n^2).
	 * 
	 * @param array the array to be sorted
	 */
	private static void insertionSort(int [] array) {
		for(int i = 1; i < array.length; i++) {
			for(int j = 0; j > 0; j--) {
				if(array[j] < array[j - 1]) {
					swap(array, j, j - 1);
					printArray(array);
				}
			}
		}
	}

	/**
	 * Implementing the merge sort. This has a time complexity of O(nlogn).
	 * 
	 * @param array the array to be sorted
	 * @param low the lower index from which sorting begins
	 * @param high the higher index till sorting takes place
	 */
	private static void mergeSort(int[] array, int low, int high) {
		if(low < high) {
			int middle = (low + high)/2;
			mergeSort(array, low, middle);
			mergeSort(array, middle + 1, high);
			merge(array, low, middle, high);
		}
	}

	/**
	 * Helper method used by merge sort.
	 * 
	 * @param array the array to be sorted
	 * @param low the lower index from which merging begins
	 * @param middle the middle index which is central to the merge
	 * @param high the higher index till which merging takes place
	 */
	private static void merge(int[] array, int low, int middle, int high) {
		int tempMerge[] = new int[array.length];
		for(int i = low; i <= high; i++) {
			tempMerge[i] = array[i];
		}
		int l = low;
		int m = middle + 1;
		int h = low;
		while(l <= middle && m <= high) {
			if(tempMerge[l] <= tempMerge[m]) {
				array[h] = tempMerge[l];
				l++;
			}
			else {
				array[h] = tempMerge[m];
				m++;
			}
			h++;

		}
		while(l <= middle) {
			array[h] = tempMerge[l];
			printArray(array);
			h++;
			l++;
		}
	}

	/**
	 * Implementing the quick sort. This has a worst case time complexity of
	 * O(n^2), but in general it is O(nlogn).
	 * 
	 * @param array the array to be sorted
	 * @param low the lower index from which sorting begins
	 * @param high the higher index till which sorting takes place
	 */
	private static void quickSort(int[] array, int low, int high) {
		int i = low;
		int j = high;
		int pivot = array[(high+low)/2];
		while(i <= j) {
			while(array[i] < pivot) {
				i++;
			}
			while(array[j] > pivot) {
				j--;
			}
			if(i <= j) {
				swap(array, i, j);
				printArray(array);
				i++;
				j--;
			}
		}
		if(low < j) {
			quickSort(array, low, j);
		}
		if(i < high) {
			quickSort(array, i, high);
		}
	}

	/**
	 * Helper method that simply swaps elements of an array.
	 * 
	 * @param array the array in which swapping occurs
	 * @param i the index of one of the swap elements
	 * @param j the index of one of the swap elements
	 */
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * Takes user input and creates an array.
	 * 
	 * @return the array the user made
	 */
	private static int[] readArray() {
		Scanner input = new Scanner(System.in);

		System.out.print("What's the size of the array: ");
		int size = input.nextInt();
		int[] array = new int[size];

		System.out.println("Enter the elements:");
		int element = 0;

		for(int i = 0; i < size; i++) {
			element = input.nextInt();
			array[i] = element;
		}

		return array;
	}

	/**
	 * Prints out the array to the screen.
	 * 
	 * @param array the array to be printed out
	 */
	private static void printArray(int [] array) {
		System.out.print("Sorting: ");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
