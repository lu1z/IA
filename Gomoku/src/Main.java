import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {
	public static void main(String... args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Board board = new Board();
		int resp = JOptionPane.showOptionDialog(board, "Escolha quem começará jogando", "Quem começa?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Computador", "Jogador" },
				null);
		board.start(resp == JOptionPane.YES_OPTION || resp == JOptionPane.CLOSED_OPTION);
	}
}