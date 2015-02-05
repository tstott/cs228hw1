package edu.iastate.cs228.hw1;


/** @author Tate Stottmann
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living {    
    int[] pop = new int[5];
    
    public Empty (World w, int r, int c){
	world = w;
	row = r;
	column = c;}
    
    public State who(){
	return State.EMPTY;}	
    /**
     * An empty square will be occupied by Badger, Fox, Rabbit, or Grass, 
     * or remain empty. 
     * @param wNew  world of the next life cycle.
     * @return Living  life form in the next cycle.   
     */
    public Living next(World wNew){
	world = wNew;
	census(pop);
	if(pop[RABBIT] > 1)
	    return new Rabbit(world,row,column,0);
	else if(pop[FOX] > 1)
	    return new Fox(world,row,column,0);
	else if(pop[BADGER] > 1)
	    return new Badger(world,row,column,0);
	else if(pop[GRASS] > 0)
	    return new Grass(world,row,column);
	else{return this;}}}
