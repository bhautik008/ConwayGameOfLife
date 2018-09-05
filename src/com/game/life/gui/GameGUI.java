package com.game.life.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

import com.game.life.algo.GameAlgo;

@SuppressWarnings("serial")
public class GameGUI extends JFrame {

	GameAlgo algo;
	GameCanvas gameCanvas;
	GameControl gameControl;
	
	public boolean autoGenerate = false;
	
	/*
	 * - inject algorithm class
	 * - call prepareGUI to create GUI and apply all button listener even and make visible
	 * - after getting GUI, creating canvas for randomly generated grid
	 */
	public GameGUI(GameAlgo algo) {
		this.algo = algo;
		prepareGUI();
		updateGrid(algo.getGrid());
	}

	private void prepareGUI() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Conway's Game of Life");
		this.setSize(600, 600);
		this.setLayout(new BorderLayout());
		
		// create canvas of grid height and width
		gameCanvas = new GameCanvas(algo.getWidth(), algo.getHeight());
		gameControl = new GameControl();

		gameControl.next.addActionListener(new ButtonClickListener());
		gameControl.start.addActionListener(new ButtonClickListener());
		gameControl.stop.addActionListener(new ButtonClickListener());
		gameControl.reset.addActionListener(new ButtonClickListener());

		this.getContentPane().add(gameCanvas, BorderLayout.CENTER);
		this.add(gameControl, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	/*
	 * set the grid to canvas class and repaint the canvas GUI to make points visible
	 */
	public void updateGrid(int[][] grid) {
		this.gameCanvas.setGrid(grid);
		this.gameCanvas.repaint();
	}

	/*
	 * get next generated grid and apply to canvas and repaint GUI
	 */
	public void nextGenerationGrid() {
		this.gameCanvas.setGrid(algo.getNextGeneration());
		this.gameCanvas.repaint();
	}
	
	/*
	 * automatically generate next generation grid every 500 milliseconds and repaint canvas GUI
	 */
	public void autoNextGenerationGrid() {
		new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// if auto generation is stopped then exit timer
				if(!autoGenerate) {
					((Timer)e.getSource()).stop();
				}
				nextGenerationGrid();
			}
		}).start();;
	}
	
	public void resetCanvas() {
		this.gameCanvas.setGrid(algo.reset());
		this.gameCanvas.repaint();
	}

	class ButtonClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String event = e.getActionCommand();
			switch (event) {
			case "Next": // to get next generation of current grid and update GUI
				autoGenerate = false;
				nextGenerationGrid();
				break;
			case "Start": // to start auto generation of grid and updating GUI
				autoGenerate = true;
				autoNextGenerationGrid();
				break;
			case "Stop": // to stop auto generation of grid
				autoGenerate = false;
				break;
			case "Reset": // to reset grid. will create new randomly generated grid
				autoGenerate = false;
				resetCanvas();
				break;
			default:
				break;
			}
		}
	}
}