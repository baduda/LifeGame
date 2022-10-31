package edu.cources.gameoflife;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board();

        do {
            board.printBoard();
            board = board.nextStep();
            System.out.println("-------------------------------------------------------");
            Thread.sleep(500L);
        } while (board.countLifeCells() > 0);

        board.printBoard();
    }
}