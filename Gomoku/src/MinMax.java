import java.util.ArrayList;
import java.util.List;

public class MinMax {
	Board b;

	public MinMax(Board b) {
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

	private List<Tile> choseHeuristicPlays(boolean player) {
		List<Tile> moves = new ArrayList<>();
		int lastLineComp = -1;
		int lastColComp = -1;
		int lastLineHum = -1;
		int lastColHum = -1;

		Tile lastCPlay = b.getLastCPlay();
		Tile lastHPlay = b.getLastHplay();

		if (lastCPlay != null) {
			lastLineComp = lastCPlay.getLine();
			lastColComp = lastCPlay.getColumn();
		}
		if (lastHPlay != null) {
			lastLineHum = lastHPlay.getLine();
			lastColHum = lastHPlay.getColumn();
		}

		for (int i = 1; i < 16; i++)
			for (int j = 1; j < 16; j++) {
				Piece piece = b.board[i][j].getPiece();
				if (piece != Piece.EMPTY)
					continue;
				if (lastCPlay != null && (lastLineComp + 1 == i || lastLineComp - 1 == i)
						&& (lastColComp + 1 == j || lastColComp - 1 == j))
					moves.add(0, b.board[i][j]);
				else if (lastHPlay != null && (lastLineHum + 1 == i || lastLineHum - 1 == i)
						&& (lastColHum + 1 == j || lastColHum - 1 == j))
					moves.add(0, b.board[i][j]);
				else
					moves.add(b.board[i][j]);
			}
		return moves;
	}

}
