package com.game.life.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameControl extends JPanel{
	
	JButton start, stop, next, reset;
	
	public GameControl() {
		start = new JButton("Start");
		stop = new JButton("Stop");
		next = new JButton("Next");
		reset = new JButton("Reset");
		
		this.setLayout(new FlowLayout());
		this.setSize(600, 100);
		this.setBackground(Color.GRAY);
		this.add(next);
		this.add(start);
		this.add(stop);
		this.add(reset);
	}
}