import java.util.Scanner;

import core.Board;
import core.Computer;
import core.Human;

public class Game {

	static Scanner in;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// build board
		Board board = new Board();
		// make players
		Human opp = new Human();
		Computer cmp = new Computer();
		// choose first player and marker
		System.out.println("First palyer ? y/n");
		in = new Scanner(System.in);
		if (in.next().charAt(0) == 'y') {
			opp.firstPlayer = true;
			cmp.firstPlayer = false;
		} else {
			cmp.firstPlayer = true;
			opp.firstPlayer = false;
		}
		System.out.println("Choose your marker X/O");
		opp.marker = in.next().charAt(0);
		cmp.marker = opp.marker == 'X' ? 'O' : 'X';
		board.cmp_marker = cmp.marker;
		board.opp_marker = opp.marker;
		// begin playing
		while (!board.gameOver()) {

			if (cmp.firstPlayer) {
				// computer turn
				cmp.firstPlayer = !cmp.firstPlayer;
				opp.firstPlayer = !opp.firstPlayer;
				cmp.palyMove(board);
				board.display();
			} else {
				// opponent turn
				opp.firstPlayer = !opp.firstPlayer;
				cmp.firstPlayer = !cmp.firstPlayer;
				opp.playMove(board);
				board.display();
			}

		}
		// Check win,loss or draw
		if (board.score() == 0) {
			System.out.println("Draw");
		} else if (board.score() >= 70) {
			System.out.println("Sorry, you lose");
		} else if (board.score() <= -70) {
			System.out.println("Congratz you win !!");
		}

	}

}
