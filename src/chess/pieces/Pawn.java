package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            // top - 1 place
            p.setValues(position.getRow() - 1, position.getCol());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getCol()] = true;
            }

            // top - 2 places
            p.setValues(position.getRow() - 2, position.getCol());
            Position p2 = new Position(position.getRow() - 1, position.getCol());

            if (getMoveCount() == 0 && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
                mat[p.getRow()][p.getCol()] = true;
            }

            // left diagonal
            p.setValues(position.getRow() - 1, position.getCol() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getCol()] = true;
            }

            // right diagonal
            p.setValues(position.getRow() + 1, position.getCol() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getCol()] = true;
            }

        } else {
            // bottom - 1 place
            p.setValues(position.getRow() + 1, position.getCol());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getCol()] = true;
            }

            // bottom - 2 places
            p.setValues(position.getRow() + 2, position.getCol());
            Position p2 = new Position(position.getRow() + 1, position.getCol());

            if (getMoveCount() == 0 && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
                mat[p.getRow()][p.getCol()] = true;
            }

            // left diagonal
            p.setValues(position.getRow() + 1, position.getCol() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getCol()] = true;
            }

            // right diagonal
            p.setValues(position.getRow() + 1, position.getCol() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getCol()] = true;
            }
        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
