package edu.iastate.cs228.hw1;




/**@author Tate Stottmann
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Living {
    private int age; 
    int[] pop = new int[5];
    /**
     * Creates a Rabbit object.
     * @param w: world  
     * @param r: row position 
     * @param c: column position
     * @param a: age 
     */
    public Rabbit (World w, int r, int c, int a){
	world = w;
	row = r;
	column = c;
	age = a;}
	
    // Rabbit occupies the square.
    public State who(){
	return State.RABBIT;}
	
    /**
     * A rabbit dies of old age or hunger, or it is eaten by a badger or a fox. 
     * @param wNew  world of the next cycle 
     * @return Living  new life form occupying the same square
     */
    public Living next(World wNew){
	world = wNew;
	census(pop);
	if(age > RABBIT_MAX_AGE)
	    return new Empty(world,row,column);
	else if(pop[GRASS] < 1)
	    return new Empty(world,row,column);
	else if(pop[BADGER] + pop[FOX] > pop[RABBIT])
	    return new Empty(world,row,column);
	else{ age +=1; return this;}}}
