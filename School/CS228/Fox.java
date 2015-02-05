package edu.iastate.cs228.hw1;


/**@author Tate Stottmann
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Living{
    private int age; 
    int[] pop = new int[5];
    /**
     * Constructor 
     * @param w: world
     * @param r: row position 
     * @param c: column position
     * @param a: age 
     */
    public Fox (World w, int r, int c, int a){
	world = w;
	row = r;
	column = c;
	age = a;}
	
    /**
     * A fox occupies the square. 	 
     */
    public State who(){
	return State.FOX;}
	
    /**
     * A fox dies of old age or hunger or attack by one or more badgers. 
     * @param wNew  world of the next cycle
     * @return Living  life form occupying the square in the next cycle. 
     */
    public Living next(World wNew){
	world = wNew;
	census(pop);
	if(age > FOX_MAX_AGE)
	    return new Empty(world,row,column);
	else if(pop[BADGER] >=  (pop[FOX]+1) )
	    return new Badger(world,row,column,0);
	else if(pop[BADGER] + pop[FOX] > pop[RABBIT])
	    return new Empty(world,row,column);
	else{ age +=1; return this;}}}
