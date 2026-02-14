package com.example;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AppTest {

    private boolean isMaxHeap(App.WordFreq[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length && arr[i].frequency < arr[left].frequency)
                return false;

            if (right < arr.length && arr[i].frequency < arr[right].frequency)
                return false;
        }
        return true;
    }

    @Test
    public void testBuildMaxHeap() {

        App.WordFreq[] phrases = new App.WordFreq[] {
                new App.WordFreq("happy", 400),
                new App.WordFreq("satisfied", 100),
                new App.WordFreq("neutral", 300),
                new App.WordFreq("would buy again", 200),
                new App.WordFreq("terrible", 160),
                new App.WordFreq("inconvenient", 900),
                new App.WordFreq("difficult to use", 100),
                new App.WordFreq("easy to use", 140),
                new App.WordFreq("would recommend to friends", 800),
                new App.WordFreq("visit the store", 700)
        };

        App.buildMaxHeap(phrases);

        // Check root is max
        assertTrue(phrases[0].frequency == 900);

        // Check heap property
        assertTrue(isMaxHeap(phrases));
    }
}