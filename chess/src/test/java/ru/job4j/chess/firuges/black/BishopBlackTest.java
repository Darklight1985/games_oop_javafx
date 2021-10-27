package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void thenPositionNorm() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell expected = bishopBlack.position();
        assertThat(expected, is(Cell.C1));
    }

    @Test
    public void rightCopy() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure expected = bishopBlack.copy(Cell.D5);
        Figure bishopBlackCopy = new BishopBlack(Cell.D5);
        assertThat(expected.position(), is(bishopBlackCopy.position()));
    }

    @Test
    public void wayRight() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] traekt = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] expected = bishopBlack.way(Cell.G5);
        Assert.assertArrayEquals(expected, traekt);
    }

    @Test
    public void wayRightSecond() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] traekt = new Cell[]{Cell.B2, Cell.A3};
        Cell[] expected = bishopBlack.way(Cell.A3);
        Assert.assertArrayEquals(expected, traekt);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void wayNotCorrect() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C8);
    }

}