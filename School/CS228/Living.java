package edu.iastate.cs228.hw1;






/**
 * 
 * Living refers to the life form occupying a square in a world grid. It is a 
 * superclass of Badger, Empty, Fox, Grass, and Rabbit, and has two abstract 
 * methods awaiting implementation. 
 *
 */
public abstract class Living{
    protected World world; // the world in which the life form resides
    protected int row;     // location of the square on which 
    protected int column;  // the life form resides
	
    // constants to be used as indices. 
    protected static final int BADGER = 0; 
    protected static final int EMPTY = 1; 
    protected static final int FOX = 2; 
    protected static final int GRASS = 3; 
    protected static final int RABBIT = 4; 
	
    public static final int NUM_LIFE_FORMS = 5; 
	
    // life expectancies 
    public static final int BADGER_MAX_AGE = 4; 
    public static final int FOX_MAX_AGE = 5; 
    public static final int RABBIT_MAX_AGE = 3; 
	
	
    /**
     * Censuses all life forms in the 3 X 3 neighborhood in a world. 
     * @param population  counts of all life forms
     */
    protected void census(int[] population){	// Takes into account the borders and populations.
	for(int i=-1;i < 2; ++i){
	    for(int j=-1;j < 2; ++j){
		if(i == 0 && j == 0){}
		else if(row == (world.getWidth()-1) && i == -1){}
		else if(column == (world.getWidth()-1) && j == 1){}
		else if(row == 0 && i == 1){}
		else if(column == 0 && j == -1){}
                else{
		    switch((world.grid[row + i][column + j]).who()){
		    case EMPTY: population[EMPTY] += 1;
			break;
		    case GRASS: population[GRASS] += 1;
			break;
		    case RABBIT: population[RABBIT] += 1;
			break;
		    case FOX: population[FOX] += 1;
			break;
		    case BADGER: population[BADGER] += 1;
			break;}}}}}
	

    /**
     * Gets the identity of the life form on the square.
     * @return State
     */
    public abstract State who();
	
    /**
     * Determines the life form on the square in the next cycle.
     * @param  wNew  world of the next cycle
     * @return Living 
     */
    public abstract Living next(World wNew); 
    // To be implemented in the classes Badger, Empty, Fox, Grass, and Rabbit. 
    // 
    // For each class (life form), carry out the following: 
    // 
    // 1. Obtains counts of life forms in the 3X3 neighborhood of the class object. 

    // 2. Applies the survival rules for the life form to determine the life form  
    //    (on the same square) in the next cycle.  These rules are given in the  
    //    project description. 
    // 
    // 3. Generate this new life form at the same location in the world wNew.      


}

