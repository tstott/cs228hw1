package edu.iastate.cs228.hw1;


/**@author Tate Stottmann
 * Grass remains if more than rabbits in the neighborhood;
 * otherwise, it is eaten. 
 *
 */
public class Grass extends Living{

    int[] pop = new int[5];
    
    public Grass (World w, int r, int c){
	world = w;
	row = r;
	column = c;}
	
    public State who(){
	return State.GRASS;}
	
    /**
     * Grass can be eaten out by rabbits in the neighborhood. 
     */
    public Living next(World wNew){
	world = wNew;
	census(pop);
        if(pop[GRASS] < (2 * pop[RABBIT]))
	    return new Empty(world,row,column);
	else if(pop[GRASS] < pop[RABBIT])
	    return new Rabbit(world,row,column,0);
	else{return this;}}}
