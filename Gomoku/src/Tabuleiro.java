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

public class Tabuleiro extends JFrame implements ActionListener {
	
	public static final int TAMANHO = 15;
	public static final int ESPACAMENTO = 1;

	private static final long serialVersionUID = 1L;
	
	Tile[][] board;
	
	SnapShoot g;
	
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
		
		System.out.println(g.toString());
	}

	private boolean makeEdge(Tile evaluating, Tile iterating, Orientation orientation, int distance) {
		if(iterating.getPiece().equals(Piece.UNAVALIABLE))
			return false;
		if(iterating.getPiece().equals(Piece.EMPTY))
			return true;
		if(evaluating.getPiece().equals(iterating.getPiece())) {
			g.addEdge(evaluating, iterating, new Link(orientation, distance));
			return true;
		}
		return false;
	}
	
	private boolean winTest(Tile evaluating) {
		int heuristicValue = 0;
		for(Orientation orientation : Orientation.values()) {
			int positives = 0;
			int negatives = 0;
			for(Link edge : g.getEdgesWith(orientation)) {
				if(edge.weigth > 0)
					positives += edge.weigth;
				else
					negatives += edge.weigth;
			}
			heuristicValue = heuristicIt(positives, negatives);
			if(heuristicValue == 15 || heuristicValue == -15)
				return true;
		}
		
		return false;
	}
	
	private int heuristicIt(int positives, int negatives) {
		
		switch(positives) {
			case 15 :
				return +quintupla;
			case 14 :
				break;
			case 13 :
				return +dupla;
			case 12 :
				break;
			case 11 :
				return +
			case 10 :
			case 9 :
			case 8 :
			case 7 :
			case 6 :
			case 5 :
			case 4 :
			case 3 :
			case 2 :
			case 1 :
		}
	}
}
