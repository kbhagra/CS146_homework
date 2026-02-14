package com.example;

/**
 * Simple program demonstrating merging two sorted arrays
 */
public class App {

    public static void main(String[] args) {
        // Basic test run
        System.out.println("Hello World!");
    }

    /**
     * Merges two already sorted integer arrays into one sorted array
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     */
    public static int[] merge_array(int[] arr1, int[] arr2) {

        // Lengths of both input arrays
        int len1 = arr1.length;
        int len2 = arr2.length;

        // Result array will hold all elements from both arrays
        int[] result = new int[len1 + len2];

        // i -> pointer for arr1
        // j -> pointer for arr2
        // k -> pointer for result array
        int k = 0, i = 0, j = 0;

        // Compare elements from both arrays and insert smaller value into result
        while (i < len1 && j < len2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];  // take element from arr1
            } else {
                result[k++] = arr2[j++];  // take element from arr2
            }
        }

        // Copy remaining elements from arr1 (if any)
        while (i < len1) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2 (if any)
        while (j < len2) {
            result[k++] = arr2[j++];
        }

        // Return merged sorted array
        return result;
    }
}
