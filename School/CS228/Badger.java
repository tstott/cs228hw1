package edu.iastate.cs228.hw1;

/**
 * A badger eats rabbits and competes against a fox. 
 * @author Tate Stottmann
 */
public class Badger extends Living{
    private int age; 
    int[] pop = new int[5];
    /**
     * Constructor 
     * @param w: world
     * @param r: row position 
     * @param c: column position
     * @param a: age 
     */
    public Badger (World w, int r, int c, int a){
	world = w;
	row = r;
	column = c;
	age = a;}
	
    /**
     * A badger occupies the square. 	 
     */
    public State who(){
	return State.BADGER;}
	
    /**
     * A badger dies of old age or hunger, or from an attack by a group of foxes when alone. 
     * @param wNew  world of the next cycle
     * @return Living  life form occupying the square in the next cycle. 
     */
    public Living next(World wNew){
	world = wNew;
	census(pop);
	if(age > BADGER_MAX_AGE)
	    return new Empty(world,row,column);
	else if((pop[BADGER] + 1) < 2 && pop[FOX] > 1)
	    return new Fox(world,row,column,0);
	else if(pop[BADGER] + pop[FOX] > pop[RABBIT])
	    return new Empty(world,row,column);
	else{ age +=1; return this;}}}
