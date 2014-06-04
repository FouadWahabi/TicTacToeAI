package core;

import java.awt.Point;
import java.util.Scanner;

public class Human {

	public boolean firstPlayer;
	public char marker;
	public void playMove(Board board) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Point p;
		do {
		System.out.println("It's your turn enter coordinates like thi : 0 0");
		p = new Point(in.nextInt(), in.nextInt());
		} while(board.contain(p, board.moves));
		board.moves.add(new Move(marker,p));
	}

}
