import java.util.ArrayList;
import java.util.List;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

public class MinMax {
	//SimpleDirectedGraph<Integer, Tile> playTree;
	
	Board b;
	int heuristicSum;
	
	public MinMax(Board b, int heuristicSum) {
		//playTree = new SimpleDirectedGraph<>(Tile.class);
		//playTree.addVertex(gHeuristic);
		this.b = b;
		this.heuristicSum = heuristicSum;
	}
	
	public int[] minMax(boolean player, int depth, int alpha, int beta) {
		
		List<Tile> nextMoves = generateMoves();
		
		Tile bestMove = nextMoves.get(0);
		
		if(nextMoves.isEmpty() || depth == 0) {
			heuristicSum = b.getGHeuristic();
			return new int[] {heuristicSum, bestMove.getLine(), bestMove.getColumn()};
		} else {
			for (Tile move : nextMoves) {
	            // try this move for the current "player"
	            b.jogar(move.getLine(), move.getColumn(), player);
	            if (player) {  // mySeed (computer) is maximizing player
	            	heuristicSum = minMax(!player, depth - 1, alpha, beta)[0];
	               if (heuristicSum > alpha) {
	                  alpha = heuristicSum;
	                  bestMove = move;
	               }
	            } else {  // oppSeed is minimizing player
	            	heuristicSum = minMax(!player, depth - 1, alpha, beta)[0];
	               if (heuristicSum < beta) {
	                  beta = heuristicSum;
	                  bestMove = move;
	               }
	            }
	            // undo move
	            b.desjogar(move.getLine(), move.getColumn());
	            // cut-off
	            if (alpha >= beta) break;
	         }
	         return new int[] {player ? alpha : beta, bestMove.getLine(), bestMove.getColumn()};
		}
	}

	private List<Tile> generateMoves() {
		List<Tile> moves = new ArrayList();
		for(int i = 1; i < 16; i++)
			for(int j = 1; j < 16; j++)
				if(b.board[i][j].getPiece().equals(Piece.EMPTY))
					moves.add(b.board[i][j]);
		return moves;
	}

	private Tile choseRandomPlay(boolean player) {
		if(player)
			return new Tile(5, 5, Piece.BLACK);
		return null;
	}
	
}
