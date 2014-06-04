package core;

import java.awt.Point;
import java.util.List;

public class Computer {

	public boolean firstPlayer;
	public char marker;

	public void palyMove(Board board) {

		int alpha = Integer.MIN_VALUE;
		int beta = Integer.MAX_VALUE;
		System.out.println("Computer turn");
		int[] nxtMove = minimax_alpha_beta(2, board, true, alpha, beta);
		board.moves.add(new Move(marker, new Point(nxtMove[1], nxtMove[2])));
	}

	private int[] minimax_alpha_beta(int depth, Board board,
			boolean cmp_player, int alpha, int beta) {

		Point best_move = new Point(-1, -1);
		if (board.gameOver() || depth == 0)
			return new int[] { board.score(), best_move.x, best_move.y };
		List<Point> pMoves = board.possibleMoves();
		if (cmp_player) {

			for (Point p : pMoves) {
				board.moves.add(new Move(marker, p));
				int score = minimax_alpha_beta(depth - 1, board, !cmp_player,
						alpha, beta)[0];
				board.moves.remove(board.moves.size()-1);
				if (score > alpha) {
					alpha = score;
					best_move = p;
				}
				if (alpha >= beta)
					break;
			}
			return new int[] { alpha, best_move.x, best_move.y };
		} else {

			for (Point p : pMoves) {
				board.moves.add(new Move(board.opp_marker, p));
				int score = minimax_alpha_beta(depth - 1, board, !cmp_player,
						alpha, beta)[0];
				board.moves.remove(board.moves.size()-1);
				if (score < beta) {
					beta = score;
					best_move = p;
				}
				if (alpha >= beta)
					break;
			}
			return new int[] { beta, best_move.x, best_move.y };

		}

	}

}
