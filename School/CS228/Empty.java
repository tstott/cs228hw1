package edu.iastate.cs228.hw1;


/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living {
    
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
	// TODO 
	// 
	// See Living.java for an outline of the function. 
	// See the project description for corresponding survival rules. 
	return null; }}
