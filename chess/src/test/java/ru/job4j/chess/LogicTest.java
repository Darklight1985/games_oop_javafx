package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test (expected = FigureNotFoundException.class)
    public void moveNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = OccupiedCellException.class)
    public void moveOccupied()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
            Figure bishopBlack = new BishopBlack(Cell.C1);
            Figure bishopBlock = new BishopBlack(Cell.E3);
        logic.add(bishopBlack);
        logic.add(bishopBlock);
        logic.move(Cell.C1, Cell.H6);
    }
}