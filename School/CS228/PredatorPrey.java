package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.lang.System;
import java.lang.String;

/**
 * @author Tate Stottmann
 * The PredatorPrey class does the predator-prey simulation over a grid world 
 * with squares occupied by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class PredatorPrey{
    /**
     * Update the new world from the old world in one cycle. 
     * @param wOld  old world
     * @param wNew  new world 
     */
    public static void updateWorld(World wOld, World wNew){
	int oww = wOld.getWidth();
	wNew = new World(oww);
	for(int r = 0;r < oww;++r){
	    for(int c = 0;c < oww;++c){
		wNew.grid[r][c] = (wOld.grid[r][c]).next(wOld);}}}
		
    // TODO 
    // 
    // For every life form (i.e., a Living object) in the grid wOld, generate  
    // a Living object in the grid wNew at the corresponding location such that 
    // the former life form changes into the latter life form. 
    // 
    // Employ the method next() of the Living class. 
	
    /**
     * Repeatedly generates worlds either randomly or from reading files. 
     * Over each world, carries out an input number of cycles of evolution. 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException{	
	Scanner scan = new Scanner(System.in);
	int trialnum = 1;
	int cycles = 0;
	int width = 0;
	String fileName = "";
	World initial = new World(0);
	World finWor = new World(0);
	boolean test = true;

	while(test){
	    System.out.print("The Predator-Prey Simulator \n keys: 1 (Random World) 2 (File Input) 3 (Exit) \n \n Trial  " + trialnum + ": ");
	    int choice = scan.nextInt();
	    switch(choice){
	    case 1: System.out.print("Random World \nEnter Grid Width: ");
	        width = scan.nextInt();
		initial = new World(width);
		initial.randomInit();
		if(initial.grid[0][0] == null)
		    System.out.println("Here");
		System.out.print("Number of Cycles: ");
		cycles = scan.nextInt();
		finWor = new World(width);
		//finWor = simulate(initial,cycles);
		System.out.print("Initial World: \n \n" + initial.toString());
		System.out.print(" \n \n Final World: \n \n" + finWor.toString());
		break;
	    case 2:
		System.out.println("World input from file \n File Name: ");
		fileName = scan.nextLine();
		System.out.println("Number of Cycles: ");
		cycles = scan.nextInt();
		initial = new World(fileName);
		finWor = simulate(initial,cycles);
		System.out.println("Initial World: \n \n" + initial.toString() + " \n \n Final World: \n \n" + finWor.toString());
		break;
	    case 3:
		test = false;}}}
	
	
	
	


	    // TODO 
	    // 
	    // Generate predator-prey simulations repeatedly like shown in the 
	    // sample run in the project description. 
	    // 
	    // 1. Enter 1 to generate a random world, 2 to read a world from an input
	    //    file, and 3 to end the simulation. (An input file always ends with 
	    //    the suffix .txt.)
	    // 
	    // 2. Print out standard messages as given in the project description. 
	    // 
	    // 3. For convenience, you may define two worlds even and odd as below. 
	    //    In an even numbered cycle (starting at zero), generate the world 
	    //    odd from the world even; in an odd numbered cycle, generate even 
	    //    from odd. 
	    // 4. Print out initial and final worlds only.  No intermediate worlds should
	    //    appear in the standard output.  (When debugging your program, you can 
	    //    print intermediate worlds.)
	    // 
	    // 5. You may save some randomly generated worlds as your own test cases. 
	    // 
	    // 6. It is not necessary to handle file input & output exceptions for this 
	    //    project. Assume data in an input file to be correctly formated. 
		
	
    
    /**
     * Does the actual simulation and returns final world.
     *@param initW
     */
    private static World simulate(World initW,int cycles){
	World even = initW;
	World odd = new World(initW.getWidth());

	for(int cy = cycles;cy > 0;--cy){
	    if((cy & 1) == 0)
		updateWorld(odd,even);
	    else
		updateWorld(even,odd);}
	if((cycles & 1) == 0)
	    return even;
	else
	    return odd;}
}
