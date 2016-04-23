import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jgrapht.EdgeFactory;
import org.jgrapht.UndirectedGraph;
/*
 * H = jogada sendo avaliada
 * X = jogada comp
 * Y = jogada huma
 * Z = vazio
 * 
 * HUMA		2^9		2^10	2^1		2^11	2^12	2^13	2^14	2^15	2^16	2^17
 * 		|	X	|	X	|	X	|	X	|	H	|	X	|	X	|	X	|	X	|	X	|
 * COMP		2^0		2^1		2^2		2^3		2^4		2^5		2^6		2^7		2^8		2^9
 */
public class Tabuleiro extends JFrame implements ActionListener {
	
	public static final int TAMANHO = 15;
	public static final int ESPACAMENTO = 1;

	private static final long serialVersionUID = 1L;
	
	Tile[][] board;
	
	SnapShoot g;
	Tile nullTile;
	
	public Tabuleiro() {
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(TAMANHO, TAMANHO, ESPACAMENTO, ESPACAMENTO));
		cp.setBackground(Color.GREEN);
		for(int i = 1; i <= TAMANHO; i++)
			for(int j = 1; j <= TAMANHO; j++) {
				String nome = i + "~" + j;
				JButton labelNome = new JButton();
				labelNome.setName(nome);
				labelNome.setBackground(Color.GRAY);
				labelNome.addActionListener(this);
				labelNome.setVisible(true);
				cp.add(nome, labelNome);
			}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gomoku");  
		setSize(496, 489);
		setVisible(true);
		board = new Tile[17][17];
		for(int i = 0; i < 17; i++)
			for(int j = 0; j < 17; j++)
				if((i == 0 || j == 0) || (i == 16 || j == 16))
					board[i][j] = new Tile(i, j, Piece.UNAVALIABLE);
				else
					board[i][j] = new Tile(i, j, Piece.EMPTY);
					
		
	}
	
	public static void main(String... args) {
		new Tabuleiro().snapShoot();
	}

	private void snapShoot() {
		// TODO Auto-generated method stub
		g = new SnapShoot(Link.class);
		nullTile = new Tile(-1 , -1, null);
		g.addVertex(nullTile);
	}

	private boolean vez = true;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton peca = (JButton)arg0.getSource();
		String[] position = peca.getName().split("~");
		int linha = Integer.valueOf(position[0]);
		int coluna = Integer.valueOf(position[1]);
		
		if(peca.getBackground() == Color.GRAY) {
			jogar(linha, coluna);
		}
	}
	
	public void jogar(int linha, int coluna) {
		JButton peca = (JButton)this.getContentPane().getComponent((linha * 15) - (16 - coluna));
		
		Piece piece;
		
		if(vez) {
			peca.setBackground(Color.BLACK);
			piece = Piece.BLACK;
		}
		else {
			peca.setBackground(Color.WHITE);
			piece = Piece.WHITE;
		}
		vez = !vez;
		
		
		board[linha][coluna].setPiece(piece);
		
		Tile evaluating = board[linha][coluna];
		g.addVertex(evaluating);
		
		g.addEdge(evaluating, nullTile , new Link(null, HeuristicUtil.bitPower[4]));
		
		Tile iterating;
		
		boolean goRight = true;
		boolean goLeft = true;
		boolean goUp = true;
		boolean goDown = true;
		boolean goAscendantRight = true;
		boolean goAscendantLeft = true;
		boolean goDescendantRight = true;
		boolean goDescendantLeft = true;
		
		for(int distance = 1; distance < 5; distance++) {
			if(goRight) {
				iterating = board[linha + distance][coluna];
				goRight = makeEdge(evaluating, iterating, Orientation.LINE, distance);
			}
			if(goLeft) {
				iterating = board[linha - distance][coluna];
				goLeft = makeEdge(evaluating, iterating, Orientation.LINE, -distance);
			}
			if(goUp) {
				iterating = board[linha][coluna + distance];
				goUp = makeEdge(evaluating, iterating, Orientation.COLUMN, distance);
			}
			if(goDown) {
				iterating = board[linha][coluna - distance];
				goDown = makeEdge(evaluating, iterating, Orientation.COLUMN, -distance);
			}
			if(goAscendantRight) {
				iterating = board[linha + distance][coluna + distance];
				goAscendantRight = makeEdge(evaluating, iterating, Orientation.ASCENDANT_DIAGONAL, distance);
			}
			if(goAscendantLeft) {
				iterating = board[linha - distance][coluna - distance];
				goAscendantLeft = makeEdge(evaluating, iterating, Orientation.ASCENDANT_DIAGONAL, -distance);
			}
			if(goDescendantRight) {
				iterating = board[linha + distance][coluna - distance];
				goDescendantRight = makeEdge(evaluating, iterating, Orientation.DESCENDANT_DIAGONAL, -distance);
			}
			if(goDescendantLeft) {
				iterating = board[linha - distance][coluna + distance];
				goDescendantLeft = makeEdge(evaluating, iterating, Orientation.DESCENDANT_DIAGONAL, distance);
			}
		}
		
		//System.out.println(g.toString());
		winTest(evaluating);
	}

	private boolean makeEdge(Tile evaluating, Tile iterating, Orientation orientation, int relativePosition) {
		if(iterating.getPiece().equals(Piece.UNAVALIABLE)) {
			g.addEdge(evaluating, nullTile, new Link(orientation, HeuristicUtil.bitPower[13 + relativePosition]));
			return false;
		}
		if(iterating.getPiece().equals(Piece.EMPTY))
			return true;
		if(evaluating.getPiece().equals(iterating.getPiece())) {
			g.addEdge(evaluating, iterating, new Link(orientation, HeuristicUtil.bitPower[4 + relativePosition]));
			return true;
		}
		else
			g.addEdge(evaluating, iterating, new Link(orientation, HeuristicUtil.bitPower[13 + relativePosition]));
		return false;
	}
	
	private boolean winTest(Tile evaluating) {
		int heuristicValue = 0;
		for(Orientation orientation : Orientation.values()) {
			int sumPositions = 0;
			for(Link edge : g.getEdgesWith(evaluating, orientation))
				sumPositions += edge.weigth;
			heuristicValue += heuristicIt(sumPositions);
			
			System.out.println(sumPositions + "       " + heuristicValue);
		}
		return false;
	}
	
	private int heuristicIt(int positions) {
		int evaluating = 0;
		int maskRedundancy = 0;
		for(Mask mask : Mask.values()) {
			for(int i = mask.spatialRedundancy; i >= 0 ; i--) {
				maskRedundancy = mask.mask << i;
				evaluating = positions & maskRedundancy;
				evaluating = evaluating >> i;
				if(evaluating == mask.value)
					return mask.heuristic;
			}
		}
		return 0;
	}
}
