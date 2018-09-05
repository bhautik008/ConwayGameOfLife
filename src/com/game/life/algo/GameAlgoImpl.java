package com.game.life.algo;

public class GameAlgoImpl implements GameAlgo{
	
	int[][] grid;
	int width,height;
	
	/*
	 * constructor
	 * @param - width, height of grid
	 * initialize grid and call fillGrid method to generate GUI
	 */
	public GameAlgoImpl(int w, int h) {
		grid = new int[w][h];
		this.width = w;
		this.height = h;
		fillGrid();
	}
	
	@Override
	public int getWidth() {
		return this.width;
	}



	@Override
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public int[][] getGrid() {
		return this.grid;
	}
	
	/*
	 * create random points on canvas
	 */
	public void fillGrid() {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				grid[i][j] = (Math.random() < 0.08) ? 1 : 0;
			}
		}
	}
	
	@Override
	public int[][] getNextGeneration() {
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				this.grid[i][j] = isAlive(i, j);
			}
		}
		return this.grid;
	}
	
	@Override
	public int[][] reset() {
		this.grid = new int[this.width][this.height];
		this.fillGrid();
		return this.grid;
	}
	
	/*
	 * test method to print grid array in console
	 */
	public void pringGrid() {
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				System.out.print((this.grid[i][j]==1)?"*":".");
			}
			System.out.println();
		}
	}
	
	@Override
	public int isAlive(int x, int y) {
		int aliveNeighbours = 0;
		if(x == 0 && y == 0) {
			for(int p=0;p<=1;p++) {
				for(int q=0;q<=1;q++) {
					aliveNeighbours += (this.grid[x+p][y+q] == 1)? 1 : 0;
				}
			}
			aliveNeighbours -= this.grid[x][y];
		} else if(x==this.width-1 && y == this.height-1) {
			for(int p=-1;p<=0;p++) {
				for(int q=-1;q<=0;q++) {
					aliveNeighbours += (this.grid[x+p][y+q] == 1)? 1 : 0;
				}
			}
			aliveNeighbours -= this.grid[x][y];
		} else if(x==0 && y == this.height-1) {
			if(this.grid[x][y-1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x+1][y] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x+1][y-1] == 1) {
				aliveNeighbours++;
			}
		} else if(x==this.width-1 && y==0) {
			if(this.grid[x-1][y] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x-1][y+1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x][y+1] == 1) {
				aliveNeighbours++;
			}
		} else if(x==0 && (1 <= y || y <= this.height-2)) {
			if(this.grid[x][y-1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x+1][y-1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x+1][y] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x+1][y+1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x+1][y+1] == 1) {
				aliveNeighbours++;
			}
		} else if((1 <= x || x <= this.width-2) && y==0) {
			if(this.grid[x-1][y] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x-1][y+1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x][y+1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x+1][y+1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x+1][y] == 1) {
				aliveNeighbours++;
			}
		} else if(x==this.width-1 && (1 <= y || y <= this.height-2)) {
			if(this.grid[x][y-1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x-1][y-1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x-1][y] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x-1][y+1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x][y+1] == 1) {
				aliveNeighbours++;
			}
		} else if((1 <= x || x <= this.width-2) && y==this.height-1) {
			if(this.grid[x-1][y] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x-1][y-1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x][y-1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x+1][y-1] == 1) {
				aliveNeighbours++;
			}
			if(this.grid[x+1][y] == 1) {
				aliveNeighbours++;
			}
		} else {
			for(int p=-1;p<=1;p++) {
				for(int q=-1;q<=1;q++) {
					aliveNeighbours += (this.grid[x+p][y+q] == 1) ? 1 : 0;
				}
			}
			aliveNeighbours -= this.grid[x][y];
		}
		if(aliveNeighbours < 2) {
			return 0;
		}
		if(aliveNeighbours > 3) {
			return 0;
		}
		if(aliveNeighbours == 3) {
			return 1;
		}
		return this.grid[x][y];
	}
}
