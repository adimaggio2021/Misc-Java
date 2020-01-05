/* Falling Sand Lab Code
 * Nifty Assignments 2017
 * AP CS A, May 2019
 * Anthony DiMaggio
 */

import java.awt.*;
import java.util.*;

public class SandLab
{
  public static void main(String[] args)
  {
    SandLab lab = new SandLab(120, 80);
    lab.run();
  }
  
  //add constants for particle types here
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;
  public static final int BALLOON = 4;
  public static final int CLOUD = 5;
  public static final int RAINCLOUD = 6;
  
  //do not add any more fields
  private int[][] grid;
  private SandDisplay display;
  private int cols;
  
  public SandLab(int numRows, int numCols)
  {
	  //initialize names and display
    String[] names;
    names = new String[7];
    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[SAND] = "Sand";
    names[WATER] = "Water";
    names[BALLOON] = "Balloon";
    names[CLOUD] = "Cloud";
    names[RAINCLOUD] = "Rain Cloud";
    display = new SandDisplay("Falling Sand", numRows, numCols, names);
    cols = numCols;
    grid = new int[numRows][numCols];
  }
  
  //called when the user clicks on a location using the given tool
  private void locationClicked(int row, int col, int tool)
  {
	  //update clicked pixel
	  grid[row][col] = tool;
  }

  //copies each element of grid into the display
  public void updateDisplay()
  {
	  //sets specific colors for each material
	  for(int i = 0; i< grid.length;i++) {
		  for(int j = 0; j< cols; j++) {
			 if(grid[i][j] == EMPTY) {
				 display.setColor(i, j, new Color(0,0,0));
			 }else if(grid[i][j] == METAL) {
				 display.setColor(i, j, new Color(200,200,200));
			 }else if (grid[i][j] == SAND) {
				 display.setColor(i, j, new Color(232, 227, 83));
			 }else if (grid[i][j] == WATER) {
				 display.setColor(i, j, new Color(51, 162, 214));
			 }else if (grid[i][j] == BALLOON) {
				 display.setColor(i, j, new Color(20, 200, 20));
			 }else if (grid[i][j] == CLOUD) {
				 display.setColor(i, j, new Color(255,255,255));
			 }else if (grid[i][j] == RAINCLOUD) {
				 display.setColor(i, j, new Color(120, 120, 120));
			 }
		  }
	  }
  }

  //called repeatedly.
  //causes one random particle to maybe do something.
  public void step()
  {
	  Random r = new Random();
	  int srow = r.nextInt(grid.length);
	  int scol = r.nextInt(cols);
	  //FALLING SAND!
	  if (srow != grid.length-1 && grid[srow][scol] == SAND && grid[srow+1][scol] == EMPTY) {
		 grid[srow][scol] = EMPTY;
		 grid[srow+1][scol] = SAND; 
	  }else if(srow != grid.length-1 && grid[srow][scol] == SAND && grid[srow+1][scol] == WATER) {
			 grid[srow][scol] = WATER;
			 grid[srow+1][scol] = SAND;
	  }
		  else if(grid[srow][scol] == WATER) {
		   //random water movement
		  int dir = r.nextInt(4);
		  if(dir == 0 && scol !=0 && grid[srow][scol-1] == EMPTY) {
			  grid[srow][scol] = EMPTY;
			  grid[srow][scol-1] = WATER;
		  }
		  if((dir == 1 || dir == 3) && srow != grid.length-1 && grid[srow+1][scol] == EMPTY) {
			  grid[srow][scol] = EMPTY;
			  grid[srow+1][scol] = WATER;
		  }
		  if(dir == 2 && scol != cols -1 && grid[srow][scol+1] == EMPTY) {
			  grid[srow][scol] = EMPTY;
			  grid[srow][scol+1] = WATER;
		  }
	  }	else if(srow != 0 && grid[srow][scol] == BALLOON && (grid[srow-1][scol] == EMPTY || grid[srow-1][scol] == WATER ||grid[srow-1][scol] == BALLOON )) {
		 //balloon moves up if water or sand isn't blocking.
		  if(grid[srow-1][scol] == EMPTY) {
			  grid[srow][scol] = EMPTY;
			  grid[srow-1][scol] = BALLOON;
		  }else if(grid[srow-1][scol] == WATER) {
			  grid[srow][scol] = WATER;
			  grid[srow-1][scol] = BALLOON;
		  } else if(grid[srow-1][scol] == BALLOON) {
			  //if there's another balloon above, first balloon tries to move around
			  int dir = r.nextInt(2);
			  if(dir == 0 && scol !=0 && grid[srow][scol-1] == EMPTY) {
			  grid[srow][scol] = EMPTY;
			  grid[srow][scol-1] = BALLOON;
			  }
			  if(dir == 1 && scol != cols -1 && grid[srow][scol+1] == EMPTY) {
				  grid[srow][scol] = EMPTY;
				  grid[srow][scol+1] = BALLOON;
			  }
		  }
	  }else if(grid[srow][scol] == CLOUD ) {
		  //Clouds and rainclouds move in horizontal line
		  int dir = r.nextInt(2);
		  if(dir == 0 && scol !=0 && grid[srow][scol-1] == EMPTY) {
			  grid[srow][scol] = EMPTY;
			  grid[srow][scol-1] = CLOUD;
			  }
			  if(dir == 1 && scol != cols -1 && grid[srow][scol+1] == EMPTY) {
				  grid[srow][scol] = EMPTY;
				  grid[srow][scol+1] = CLOUD;
			  }
		  
		  
	  }else if(grid[srow][scol] == RAINCLOUD ) {
		  //Clouds and rainclouds move in horizontal line
		  int dir = r.nextInt(2);
		  if(dir == 0 && scol !=0 && grid[srow][scol-1] == EMPTY) {
			  grid[srow][scol] = EMPTY;
			  grid[srow][scol-1] = RAINCLOUD;
			  }
			  if(dir == 1 && scol != cols -1 && grid[srow][scol+1] == EMPTY) {
				  grid[srow][scol] = EMPTY;
				  grid[srow][scol+1] = RAINCLOUD;
			  }
			 dir = r.nextInt(10);
			  //raincloud spawns water only 10% of time because it was too agressive before
		 if(srow != grid.length-1 && grid[srow+1][scol] == EMPTY && dir == 0) {
			 grid[srow+1][scol] = WATER;
		 }
		  
		  
	  }
  }
  
  //do not modify
  public void run()
  {
    while (true)
    {
      for (int i = 0; i < display.getSpeed(); i++)
        step();
      updateDisplay();
      display.repaint();
      display.pause(1);  //wait for redrawing and for mouse
      int[] mouseLoc = display.getMouseLocation();
      if (mouseLoc != null)  //test if mouse clicked
        locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
    }
  }
}
