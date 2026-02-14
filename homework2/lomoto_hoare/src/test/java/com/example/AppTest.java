package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for Lomuto and Hoare partition methods
 */
public class AppTest {

    // Already sorted input
    int[] sortedArray = { 10, 17, 19, 21, 44, 55, 57, 63, 65, 67 };

    // Random unsorted input
    int[] randomArray = { 84, 3, 7, 1, 9, 6, 2, 5 };

    // Lomuto should return a valid pivot index
    @Test
    public void testLomutoOnSortedArray() {
        int[] arr = sortedArray.clone();
        int pivotIndex = App.lomutoPartition(arr, 0, arr.length - 1);

        assertTrue(pivotIndex >= 0);
    }

    // Verify elements left of pivot <= pivot and right >= pivot
    @Test
    public void testLomutoOnRandomArray() {
        int[] arr = randomArray.clone();
        int pivotIndex = App.lomutoPartition(arr, 0, arr.length - 1);

        int pivot = arr[pivotIndex];

        for (int i = 0; i < pivotIndex; i++) {
            assertTrue(arr[i] <= pivot);
        }

        for (int i = pivotIndex + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= pivot);
        }
    }

    // Edge case: empty array
    @Test
    public void testLomutoOnEmptyArray() {
        int[] arr = {};
        int result = App.lomutoPartition(arr, 0, 0);
        assertEquals(-1, result);
    }

    // Hoare should return a valid partition boundary
    @Test
    public void testHoareOnSortedArray() {
        int[] arr = sortedArray.clone();
        int partitionIndex = App.hoarePartition(arr, 0, arr.length - 1);

        assertTrue(partitionIndex >= 0);
    }

    // Check partition property relative to pivot (first element)
    @Test
    public void testHoareOnRandomArray() {
        int[] arr = randomArray.clone();
        int pivot = arr[0];
        int partitionIndex = App.hoarePartition(arr, 0, arr.length - 1);

        assertTrue(partitionIndex >= 0 && partitionIndex < arr.length);

        for (int i = 0; i <= partitionIndex; i++) {
            assertTrue(arr[i] <= pivot);
        }

        for (int i = partitionIndex + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= pivot);
        }
    }

    // Edge case: empty array
    @Test
    public void testHoareOnEmptyArray() {
        int[] arr = {};
        int result = App.hoarePartition(arr, 0, 0);
        assertEquals(-1, result);
    }
}
