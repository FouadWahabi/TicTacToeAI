package core;

import java.awt.Point;

public class Move {
	public Point pos;
	public char marker;

	public Move(char marker, Point pos) {
		this.pos = pos;
		this.marker = marker;
	}

}
