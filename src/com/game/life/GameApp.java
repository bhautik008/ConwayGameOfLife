package com.game.life;

import com.game.life.algo.GameAlgo;
import com.game.life.algo.GameAlgoImpl;
import com.game.life.gui.GameGUI;

/*
 * @author - bhautik bhanani
 * main class - GameApp
 * software requirement - Java v6 or up
 */
public class GameApp {

	/*
	 * - create grid with width of 165 and 200. right now canvas is set to this size as window is also 600x600 of size
	 * - create game GUI and apply algorithm and perform operations
	 */
	
	public static void main(String[] args) {
		GameAlgo algo = new GameAlgoImpl(165,200);
		@SuppressWarnings("unused")
		GameGUI gameGUI = new GameGUI(algo);
	}
}
