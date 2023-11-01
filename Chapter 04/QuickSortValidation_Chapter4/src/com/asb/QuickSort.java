package com.asb;

public class QuickSort {
public static void main(String[] args) {
    // int[] arr = { 9, 7, 5, 11, 12, 2, 14, 3, 10, 6 };
    int[] arr = { 12, 11, 13, 5, 6, 7 };                 //ASB Changed to match the other test data
    long startTime = System.nanoTime(); //ASB Added for timing
    System.out.println("Original array:");
    printArray(arr);
    
    quickSort(arr, 0, arr.length - 1);
    
    System.out.println("Sorted array:");
    printArray(arr);
    long endTime = System.nanoTime();  //ASB Added for timing
    System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");  //ASB Changed for timing
}

public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

public static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
}

public static void printArray(int[] arr) {
    for (int num : arr) {
        System.out.print(num + " ");
    }
    System.out.println();
}
}

