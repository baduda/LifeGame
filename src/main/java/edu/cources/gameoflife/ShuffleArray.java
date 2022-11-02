package edu.cources.gameoflife;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        shuffleArray(cards);

        int[] player1 = Arrays.copyOfRange(cards, 0, 5);
        int[] player2 = Arrays.copyOfRange(cards, 5, 10);

        System.out.println("player1 = " + Arrays.toString(player1));
        System.out.println("player2 = " + Arrays.toString(player2));
    }

    private static void shuffleArray(int[] array) {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            if (index != i) {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }
}
