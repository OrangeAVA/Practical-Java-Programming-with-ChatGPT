package com.asb;

import java.util.Arrays;

public class TimSort { //ASB Changed the name TimSortExample to TimSort

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array: " + Arrays.toString(arr));

        //long startTime = System.currentTimeMillis(); //ASB Update made below to nanoTime (ChatGPT recommended)
        long startTime = System.nanoTime();
        Arrays.sort(arr);
        //long endTime = System.currentTimeMillis();   //ASB Update made below to nanoTime (ChatGPT recommended)
        long endTime = System.nanoTime();

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds"); //ASB Changed to nanoseconds
    }
}

