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
        int count = 0;
        for (boolean[] row : cells) {
            for (boolean cell : row) {
                if (cell) count++;
            }
        }
        return count;
    }

    public int countNeighbors(int x, int y) {
        int count = 0;
        count += isLifeCell(x - 1, y - 1);
        count += isLifeCell(x, y - 1);
        count += isLifeCell(x + 1, y - 1);
        count += isLifeCell(x - 1, y);
        count += isLifeCell(x + 1, y);
        count += isLifeCell(x - 1, y + 1);
        count += isLifeCell(x, y + 1);
        count += isLifeCell(x + 1, y + 1);
        return count;
    }

    private int isLifeCell(int x, int y) {
        if (x < 0) return 0;
        if (x >= cells.length) return 0;
        if (y < 0) return 0;
        if (y >= cells[x].length) return 0;
        if (cells[x][y]) return 1;
        return 0;
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
