package test;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[] {
				8,6,7,5,3,0,9
		};
		printlist(test);
		//int[] result = mergeSort(test);
		//printlist(result);
		int[] result2 = quicksort(test, test.length/2, 0, test.length - 1);
		printlist(result2);

	}
	
	public static int[] mergeSort(int[] arr) {
		int [] left = new int[arr.length/2];
		int [] right = new int[arr.length-arr.length/2];
		if (arr.length == 1) {
			return arr;
		} else {
			for (int i = 0; i < arr.length; i ++) {
				if (i < left.length) {
					left[i] = arr[i];
				} else {
					right[i - left.length] = arr[i];
				}
			}
		}
		left = mergeSort(left);
		right = mergeSort(right);
		printlist(left);
		printlist(right);
		
		int[] toReturn = new int[left.length + right.length];
		int leftindex = 0;
		int rightindex = 0;
		for (int j = 0; j < toReturn.length; j ++) {
			
			if(left[leftindex] <= right[rightindex]) {
				toReturn[j] = left[leftindex];
				leftindex++;
			} else {
				toReturn[j] = right[rightindex];
				rightindex++;
			}
			if (leftindex >= left.length) {
				j ++;
				while (j < toReturn.length) {
					toReturn[j] = right[rightindex];
					j ++;
					rightindex++;
				}
			} else if (rightindex >= right.length) {
				j ++;
				while (j < toReturn.length) {
					toReturn[j] = left[leftindex];
					j ++;
					leftindex++;
				}
			}
		}
		
		return toReturn;
	}
	
	public static int[] quicksort(int arr[], int pivot, int lbound, int rbound) {
		System.out.println ("Before first swap");
		printlist(arr);
		System.out.println ("lbound = " + lbound + " rbound = " + rbound + " pivot = " + pivot);
		
		System.out.println ("after first swap");
		printlist(arr);
		int lowerIndex = lbound;
		int higherIndex;
		if (lbound >= rbound) {
			System.out.println ("in here!!!" );
			return arr;
		} else if (lbound + 1 == rbound) {
			if (arr[lbound] > arr[rbound]) {
				swap(arr, lbound, rbound);
			}
			return arr;
		} else {
			arr = swap(arr, pivot, lbound);
			for (higherIndex = lbound + 1; higherIndex < rbound; higherIndex ++) {
				if (arr[higherIndex] < arr[lbound]) {
					lowerIndex ++;
					arr = swap(arr,lowerIndex, higherIndex);
					System.out.println ("higher index is smaller than the pivot");
					printlist(arr);
				}
			}
			//System.out.println ("lindex = " + lowerIndex + " lbound = " + lbound);
			arr = swap(arr, lowerIndex, lbound);
			System.out.println ("after final swap before return \n");
			printlist(arr);
			//System.out.println ("left recursion called");
			arr = quicksort(arr, (lowerIndex - lbound) / 2,lbound, lowerIndex - 1);
//			System.out.println ("left recursion ended and right recursion starts with lbound: " + lbound + " and Rbound " + rbound);
			arr = quicksort(arr,(rbound + lowerIndex + 2) / 2, lowerIndex + 1, rbound);
//			System.out.println ("right recursion endes");
			return arr;
		}		
	}
	
	private static int[] swap(int arr[], int swap1, int swap2) {
		//System.out.println ("lindex = " + swap1 + " lbound = " + swap2);
		int temp = arr[swap1];
		arr[swap1] = arr[swap2];
		arr[swap2] = temp;
		return arr;
	}
	
	
	
	public static void printlist(int[] arr) {
		int j = 0;
		while (j < arr.length) {
			System.out.print(arr[j] + ", ");
			j ++;
		}
		System.out.println();
	}


}
