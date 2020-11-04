package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Board Error: there's need to be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!checkPositionExists(row, column)) {
            throw new BoardException("Board Error: position does not exists");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Board Error: position does not exists");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (isThereAPiece(position)) {
            throw new BoardException("Board Error: there's already a piece in this position");
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean checkPositionExists (int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists (Position position) {
        return checkPositionExists(position.getRow(), position.getColumn());
    }

    public boolean isThereAPiece (Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Board Error: position does not exists");
        }
        return piece(position) != null;
    }
}
