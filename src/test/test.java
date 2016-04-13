package test;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[] {
				8,6,7,5,3,0,9
		};
		printlist(test);
		int[] result = mergeSort(test);
		printlist(result);

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
	public static void printlist(int[] arr) {
		int j = 0;
		while (j < arr.length) {
			System.out.print(arr[j] + ", ");
			j ++;
		}
		System.out.println();
	}


}
