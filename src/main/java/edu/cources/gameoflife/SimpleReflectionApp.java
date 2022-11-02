package edu.cources.gameoflife;

import java.lang.reflect.Method;

public class SimpleReflectionApp {
    public static void main(String[] args) {
        Board board = new Board();

        for (Method method : board.getClass().getDeclaredMethods()) {
            System.out.println("method = " + method.getName());
        }
    }
}
