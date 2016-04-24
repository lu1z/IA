public class Tile {
	public static final Tile nullTile = new Tile(-1, -1, Piece.UNAVALIABLE);
	
	private int line;
	private int column;
	private Piece piece;
	
	public Tile(int line, int column, Piece piece) {
		this.line = line;
		this.column = column;
		this.piece = piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}
}
