package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getY() - dest.getY());
        Cell[] steps = new Cell[size];
        int deltaX = size / (dest.getX() - position.getX());
        int deltaY = size / (dest.getY() - position.getY());
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(position.getX() + deltaX * (index + 1),
                    position.getY() + deltaY * (index + 1));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        int x1 = source.getX();
        int y1 = source.getY();
        int x2 = dest.getX();
        int y2 = dest.getY();
        if (coordBoard(x1) && coordBoard(x2) && coordBoard(y1) && coordBoard(y2)) {
            if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                rsl = true;
            }
        }
        return rsl;
    }

    public static boolean coordBoard(int num) {
        return num > -1 && num < 8;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
