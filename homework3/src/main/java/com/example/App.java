package com.example;

public class App {

    // Each object stores a phrase + its frequency (priority)
    static class WordFreq {
        String word;
        int frequency;

        WordFreq(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return word + " (" + frequency + ")";
        }
    }

    // Standard maxHeapify: assume children are heaps, fix node i
    private static void maxHeapify(WordFreq[] arr, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && arr[left].frequency > arr[largest].frequency) {
            largest = left;
        }
        if (right < heapSize && arr[right].frequency > arr[largest].frequency) {
            largest = right;
        }

        if (largest != i) {
            WordFreq temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, heapSize, largest);
        }
    }

    // BUILD-MAX-HEAP (bottom-up)
    public static void buildMaxHeap(WordFreq[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    private static void printArray(WordFreq[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i]);
        }
    }

    public static void main(String[] args) {

        // Create the array from the given data
        WordFreq[] phrases = new WordFreq[] {
                new WordFreq("happy", 400),
                new WordFreq("satisfied", 100),
                new WordFreq("neutral", 300),
                new WordFreq("would buy again", 200),
                new WordFreq("terrible", 160),
                new WordFreq("inconvenient", 900),
                new WordFreq("difficult to use", 100),
                new WordFreq("easy to use", 140),
                new WordFreq("would recommend to friends", 800),
                new WordFreq("visit the store", 700)
        };

        // Build max-heap using bottom-up construction
        buildMaxHeap(phrases);

        // Print heapified order (array representation of the heap)
        System.out.println("Heapified array (max-heap by frequency):");
        printArray(phrases);
    }
}