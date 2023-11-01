package com.asb;
import java.util.Arrays;
import java.util.Random;                                               //ASB New Import from the RandomArray code example
import com.asb.MergeSort;	                                           //ASB New Import from the MergeSort method created in Chapter 4
public class BinarySearchValidatiion {
//	public class BinarySearch {                                        //ASB Original Class name changed  13-08-2023
		public static int binarySearchValidation(int[] arr, int key) { //ASB Original method name changed 13-08-2023
			int low = 0;         
			int high = arr.length - 1;         
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (arr[mid] == key) {
					return mid;             
					} else if (arr[mid] < key) {
						low = mid + 1;
						} else {
							high = mid - 1;
							}
							}
							return -1;
							}
							public static void main(String[] args)
							{
								// int[] arr = {1, 2, 3, 4, 5};
								//   int key = 3; We want to ensure we find one of the actual elements
								// New Code added from Perplexity to populate a test array, start time and sort it
								   
							       long startTime = System.nanoTime(); //ASB We log the start time

						        int[] arr = new int[10];
						        Random rand = new Random();

						        for (int i = 0; i < arr.length; i++) {
						            arr[i] = rand.nextInt(100); // generate random integer between 0 and 99
						        }

						        // print the array
						        int key = 0; //ASB We set the key starting at zero, then we use the last Randomly generated element for the key
						        for (int i = 0; i < arr.length; i++) {
						            System.out.print(arr[i] + " ");
						            key = arr[i]; //ASB this should give us the randomly selected last element as the key to be searched
						        }
                                //ASB Now we use the MergeSort we created earlier in Chapter 4
							    System.out.println("Original array: " + Arrays.toString(arr));
							    System.out.println("Search key: " + Integer.toString(key));  //ASB we also print the key to be found
						        MergeSort.mergeSort(arr, 0, arr.length - 1);
						        System.out.println("Sorted array: " + Arrays.toString(arr));
								// End New Code
								int result = binarySearchValidation(arr, key); //ASB Original method name changed 13-08-2023
						        long endTime = System.nanoTime();			   //ASB We log the end time		        
						        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");  //ASB Changed to nanoseconds from milliseconds
								if (result == -1) {
									System.out.println("Element not found");
									} else {
										System.out.println("Element found at index " + result);
									}
							}
}
