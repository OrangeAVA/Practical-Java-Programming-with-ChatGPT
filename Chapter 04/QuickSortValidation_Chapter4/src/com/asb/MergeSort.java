package com.asb;

import java.util.Arrays;

public class MergeSort { //ASB Changed name to MergeSort from MergeSortExample

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArray[i++];
        }

        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Original array: " + Arrays.toString(arr));
        //long startTime = System.currentTimeMillis(); //ASB Update made below to nanoTime (ChatGPT recommended)
        long startTime = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1);
        //long endTime = System.currentTimeMillis();   //ASB Update made below to nanoTime (ChatGPT recommended)
        long endTime = System.nanoTime();

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");  //ASB Changed to nanoseconds from milliseconds
    }
}
