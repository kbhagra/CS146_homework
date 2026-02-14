package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for merge_array method
 */
public class AppTest {

    /**
     * Tests normal case:
     * Two sorted arrays of same size
     * Expected → fully merged sorted array
     */
    @Test
    void testMergeNormalCase() {
        int[] arr1 = { 1, 3, 5 };
        int[] arr2 = { 2, 4, 6 };

        int[] expected = { 1, 2, 3, 4, 5, 6 };
        int[] result = App.merge_array(arr1, arr2);

        // Verify result matches expected sorted output
        assertArrayEquals(expected, result);
    }

    /**
     * Tests edge case:
     * One array is empty
     * Expected → return the non-empty array unchanged
     */
    @Test
    void testMergeWithEmptyArray() {
        int[] arr1 = {};
        int[] arr2 = { 1, 2, 3 };

        int[] result = App.merge_array(arr1, arr2);

        // Merging with empty array should return the other array
        assertArrayEquals(arr2, result);
    }

    /**
     * Tests handling of duplicate values
     * Expected → duplicates preserved and sorted correctly
     */
    @Test
    void testMergeWithDuplicates() {
        int[] arr1 = { 1, 2, 2 };
        int[] arr2 = { 2, 3 };

        int[] expected = { 1, 2, 2, 2, 3 };
        int[] result = App.merge_array(arr1, arr2);

        // Ensure duplicates are not lost during merge
        assertArrayEquals(expected, result);
    }
}
