package com.game.life.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameCanvas extends JPanel{
	
	int[][] grid;
	
	/*
	 * create canvas 3 times larger than grid, as point size is 3x3
	 */
	public GameCanvas(int w, int h) {
		this.setSize(w * 3, h * 3);
		this.grid = new int[w][h];
		this.setBackground(Color.WHITE);
	}
	
	/*
	 * set grid
	 */
	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#printComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color gColor = g.getColor();
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==1) {
					g.setColor(Color.RED);
					g.fillRect(j*3, i*3, 3, 3);
				}
			}
		}
		g.setColor(gColor);
	}
}
