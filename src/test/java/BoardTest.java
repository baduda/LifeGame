import edu.cources.gameoflife.Board;
import org.junit.jupiter.api.*;

public class BoardTest {

    private Board emptyBoard;

    @BeforeEach
    public void beforeAll() {
        emptyBoard = new Board(new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false},
        });
    }

    @Test
    public void test() {
        Board board = new Board(new boolean[][]{{false, true, true}});
        int cells = board.countLifeCells();
        Assertions.assertEquals(2, cells);
    }

    @Test
    public void shouldCountLifeCellsForEmptyBoard() {
        int cells = emptyBoard.countLifeCells();
        Assertions.assertEquals(0, cells);
    }

    @Test
    public void shouldCountLifeCellsForSeveralRow() {
        Board board = new Board(new boolean[][]{
                {false, false, false},
                {false, true, false},
                {true, false, false},
        });
        int cells = board.countLifeCells();
        Assertions.assertEquals(2, cells);
    }

    @Test
    public void shouldCountNeighborsOnEmptyBoard() {
        int count = emptyBoard.countNeighbors(1, 1);
        Assertions.assertEquals(0, count);
    }

    @Test
    public void shouldCountNeighbors() {
        Board board = new Board(new boolean[][]{
                {false, true, false},
                {false, true, true},
                {true, false, false},
        });
        int count = board.countNeighbors(1, 1);
        Assertions.assertEquals(3, count);
    }

    @Test
    public void shouldCountNeighborsOnBoarder() {
        Board board = new Board(new boolean[][]{
                {false, true, false},
                {false, true, true},
                {true, false, false},
        });
        int count = board.countNeighbors(1, 0);
        Assertions.assertEquals(3, count);
    }

    @Test
    public void shouldCountNeighborsOnCorner() {
        Board board = new Board(new boolean[][]{
                {false, true, false},
                {false, true, true},
                {true, false, false},
        });
        int count = board.countNeighbors(0, 2);
        Assertions.assertEquals(3, count);
    }
}
