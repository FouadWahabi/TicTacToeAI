package core;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Board {

	public List<Move> moves;
	public char cmp_marker;
	public char opp_marker;

	public Board() {
		this.moves = new LinkedList<Move>();
	}

	public boolean gameOver() {
		// TODO Auto-generated method stub
		if ((score() >= 70)||(score() <= -70))
			return true;
		return false;
	}

	public List<Point> possibleMoves() {
		List<Point> pMoves = new LinkedList<Point>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Point p = new Point(j, i);
				if (!contain(p, moves))
					pMoves.add(p);
			}
		}
		return pMoves;

	}

	public boolean contain(Point p, List<Move> moves) {
		// TODO Auto-generated method stub
		java.util.Iterator<Move> it = moves.iterator();
		while (it.hasNext()) {
			if (it.next().pos.equals(p))
				return true;
		}
		return false;
	}
	
	public Move GetMove(Point p, List<Move> moves) {
		// TODO Auto-generated method stub
		java.util.Iterator<Move> it = moves.iterator();
		Move tmp;
		while (it.hasNext()) {
			if ((tmp = it.next()).pos.equals(p))
				return tmp;
		}
		return null;
	}

	public int score() {

		int score = 0;
		// Evaluate score for each of the 8 lines (3 rows, 3 columns, 2
		// diagonals)
		score += evaluateLine(0, 0, 0, 1, 0, 2); // row 0
		score += evaluateLine(1, 0, 1, 1, 1, 2); // row 1
		score += evaluateLine(2, 0, 2, 1, 2, 2); // row 2
		score += evaluateLine(0, 0, 1, 0, 2, 0); // col 0
		score += evaluateLine(0, 1, 1, 1, 2, 1); // col 1
		score += evaluateLine(0, 2, 1, 2, 2, 2); // col 2
		score += evaluateLine(0, 0, 1, 1, 2, 2); // diagonal
		score += evaluateLine(0, 2, 1, 1, 2, 0); // alternate diagonal
		return score;
	}

	 /** The heuristic evaluation function for the current board
    @Return +100, +10, +1 for EACH 3-, 2-, 1-in-a-line for computer.
            -100, -10, -1 for EACH 3-, 2-, 1-in-a-line for opponent.
            0 otherwise   */
	private int evaluateLine(int row1, int col1, int row2, int col2, int row3,
			int col3) {
		int score = 0;
		Move tmp;
		// first cell
		if ((tmp = GetMove(new Point(col1, row1), moves)) != null) {
			if (tmp.marker == cmp_marker)
				score = 1;
			else
				score = -1;
		}
		// second cell
		if ((tmp = GetMove(new Point(col2, row2), moves)) != null) {
			if (tmp.marker == cmp_marker)
				if (score == 1)
					score = 10;
				else if(score == -1)
					score = 0;
				else
					score = 1;
			else if (score == -1)
				score = -10;
			else if(score == 1)
				score = 0;
			else
				score = 1;
		}
		// third cell
		if ((tmp = GetMove(new Point(col3, row3), moves)) != null) {
			if (tmp.marker == cmp_marker)
				if (score > 0)
					score *= 10;
				else if (score < 0)
					score = 0;
				else
					score = 1;

			else if (score < 0)
				score *= 10;
			else if (score > 0)
				score = 0;
			else
				score = -1;
		}

		return score;
	}
	
	public void display() {
		
		Move tmp;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tmp = GetMove(new Point(j, i), moves);
				if(tmp != null)
					System.out.print("| "+tmp.marker+" |");
				else
					System.out.print("|   |");
			}
			System.out.println();
		}
	}

}
