import java.util.ArrayList;
import java.util.List;

public class MinMax {
	// SimpleDirectedGraph<Integer, Tile> playTree;

	Board b;

	public MinMax(Board b) {
		// playTree = new SimpleDirectedGraph<>(Tile.class);
		// playTree.addVertex(gHeuristic);
		this.b = b;
	}

	public int[] minMax(boolean player, int depth, int alpha, int beta) {
		List<Tile> nextMoves = choseHeuristicPlays(player);

		int heuristicSum;
		int bestRow = -1;
		int bestCol = -1;

		if (nextMoves.isEmpty() || depth == 0) {
			heuristicSum = b.getGHeuristic();
			return new int[] { heuristicSum, bestRow, bestCol };
		} else {
			for (Tile move : nextMoves) {
				// try this move for the current "player"
				b.jogar(move.getLine(), move.getColumn(), player);
				if (player) { // mySeed (computer) is maximizing player
					heuristicSum = minMax(!player, depth - 1, alpha, beta)[0];
					if (heuristicSum > alpha) {
						alpha = heuristicSum;
						bestRow = move.getLine();
						bestCol = move.getColumn();
					}
				} else { // oppSeed is minimizing player
					heuristicSum = minMax(!player, depth - 1, alpha, beta)[0];
					if (heuristicSum < beta) {
						beta = heuristicSum;
						bestRow = move.getLine();
						bestCol = move.getColumn();
					}
				}
				// undo move
				b.desjogar(move.getLine(), move.getColumn());
				// cut-off
				if (alpha >= beta)
					break;
			}
			return new int[] { player ? alpha : beta, bestRow, bestCol };
		}
	}

	private List<Tile> generateMoves(boolean player) {
		List<Tile> moves = new ArrayList();
		for (int i = 1; i < 16; i++)
			for (int j = 1; j < 16; j++)
				if (b.board[i][j].getPiece().equals(Piece.EMPTY))
					moves.add(b.board[i][j]);
		return moves;
	}

	private List<Tile> choseHeuristicPlays(boolean player) {
		List<Tile> moves = new ArrayList();
		Tile lastCPlay = b.getLastCPlay();
		Tile lastHPlay = b.getLastHplay();

		for (int i = 1; i < 16; i++)
			for (int j = 1; j < 16; j++) {
				if (b.board[i][j].getPiece().equals(Piece.EMPTY) && lastCPlay != null && (lastCPlay.getLine() + 1 == i || lastCPlay.getLine() + -1 == i) && (lastCPlay.getColumn() + 1 == j || lastCPlay.getColumn() + -1 == j))
					moves.add(0, b.board[i][j]);
				else
					if (b.board[i][j].getPiece().equals(Piece.EMPTY) && lastHPlay != null && (lastHPlay.getLine() + 1 == i || lastHPlay.getLine() + -1 == i) && (lastHPlay.getColumn() + 1 == j || lastHPlay.getColumn() + -1 == j))
						moves.add(0, b.board[i][j]);
					else
						if(b.board[i][j].getPiece().equals(Piece.EMPTY))
							moves.add(b.board[i][j]);
			}
		return moves;
	}

}
