package com.game.life.algo;

/*
 * GameAlgo interface for dependency injection
 */
public interface GameAlgo {
	/*
	 * return width of grid
	 */
	public int getWidth();
	/*
	 * return height of grid
	 */
	public int getHeight();
	/*
	 * return grid array
	 */
	public abstract int[][] getGrid();
	/*
	 * return next generation by applying game rules
	 */
	public abstract int[][] getNextGeneration();
	/*
	 * rest and return grid
	 */
	public abstract int[][] reset();
	/*
	 * check current position and apply game rules
	 */
	abstract int isAlive(int x, int y);
}
