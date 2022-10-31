package edu.cources.gameoflife;

public class Board {
    private final boolean[][] cells;

    public Board() {
        cells = new boolean[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                cells[x][y] = Math.random() < 0.2;
            }
        }
    }

    public Board(boolean[][] cells) {
        this.cells = cells;
    }

    public Board nextStep() {
        boolean[][] next = new boolean[10][10];

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                boolean cell = cells[x][y];
                int count = countNeighbors(x, y);

                if (cell && (count == 2 || count == 3)) {
                    next[x][y] = true;
                } else if (!cell && count == 3) {
                    next[x][y] = true;
                } else {
                    next[x][y] = false;
                }
            }
        }
        return new Board(next);
    }

    public int countLifeCells() {
        // todo: подсчет живых клеток
        return 1;
    }

    private int countNeighbors(int x, int y) {
        //todo: добавить логику подсчета соседей
        return (int) (Math.random() * 5);
    }

    public void printBoard() {
        for (boolean[] row : cells) {
            for (boolean cell : row) {
                System.out.print(cell ? "*" : " ");
            }
            System.out.println();
        }
    }
}
