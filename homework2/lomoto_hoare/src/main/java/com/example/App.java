package com.example;

/**
 * QuickSort partition implementations: Lomuto and Hoare
 */
public class App {

    // Lomuto: pivot = last element, returns final pivot index
    public static int lomutoPartition(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return -1;

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // Hoare: pivot = first element, returns partition boundary index
    public static int hoarePartition(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return -1;

        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j)
                return j;

            swap(arr, i, j);
        }
    }

    // swap two indices
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
