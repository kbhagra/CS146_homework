package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testMergeNormalCase() {
        int[] arr1 = { 1, 3, 5 };
        int[] arr2 = { 2, 4, 6 };

        int[] expected = { 1, 2, 3, 4, 5, 6 };
        int[] result = App.merge_array(arr1, arr2);

        assertArrayEquals(expected, result);
    }

    @Test
    void testMergeWithEmptyArray() {
        int[] arr1 = {};
        int[] arr2 = { 1, 2, 3 };

        int[] result = App.merge_array(arr1, arr2);

        assertArrayEquals(arr2, result);
    }

    @Test
    void testMergeWithDuplicates() {
        int[] arr1 = { 1, 2, 2 };
        int[] arr2 = { 2, 3 };

        int[] expected = { 1, 2, 2, 2, 3 };
        int[] result = App.merge_array(arr1, arr2);

        assertArrayEquals(expected, result);
    }
}
