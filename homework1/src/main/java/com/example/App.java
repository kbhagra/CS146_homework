package com.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int[] merge_array(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        int[] result = new int[len1 + len2];

        int k = 0, i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < len1) {
            result[k++] = arr1[i++];
        }

        while (j < len2) {
            result[k++] = arr2[j++];
        }

        return result;

    }
}
