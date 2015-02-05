package edu.iastate.cs228.hw1;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.Random;
import java.lang.String;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.IOException;
import java.lang.System;
import java.lang.Math;
import java.io.FileReader;


/**
 * 
 * The world is represented as a square grid of size width X width. 
 *
 */
public class World {
    private int width; // grid size: width X width 
	
    public Living[][] grid; 
	
    /*  Default constructor reads from a file 
    **
    */
    public World(String inputFileName) throws FileNotFoundException {
	FileReader in = new FileReader(inputFileName);
	Scanner listin = new Scanner(in);
	int rowcount = 0, colcount = 0;
	int filewid = 0;	
	    while(listin.hasNextLine()){
		String lineNext = listin.nextLine();
		if(rowcount == 0 && colcount == 0){
		    width = (((listin.nextLine()).replaceAll(" ", "")).length());
		    grid = new Living[width][width];} // Creates initial grid with length of file without newlines or spaces, I am sure there is a better way, but I can't find it.
	for (String lineElement: lineNext.split("\n| ")){  //Takes care of putting objects into grid by reading out of file,
		                                         //after seperating by space or new line.
		    switch(lineElement.toUpperCase()){
		    case "B": grid[rowcount][colcount] = new Badger(this,rowcount,colcount,0);
			break;
		    case "F": grid[rowcount][colcount] = new Fox(this,rowcount,colcount,0);
			break;
		    case "G": grid[rowcount][colcount] = new Grass(this,rowcount,colcount);
			break;
		    case "R": grid[rowcount][colcount] = new Rabbit(this,rowcount,colcount,0);
			break;
		    case "E": grid[rowcount][colcount] = new Empty(this,rowcount,colcount);
			break;}
		    ++colcount;
		    if(colcount == width){
			++rowcount;
			colcount = 0;}}}}

    // TODO 
    // 
    // Assumption: The input file is in correct format. 
    // 
    // You may create the grid world in the following steps: 
    // 
    // 1) Reads the first line to determine the width of the grid.
    // 
    // 2) Creates a grid object. 
    // 
    // 3) Fills in the grid according to the input file. 
    // 
    // Be sure to close the input file when you are done.
       
	
/**
 * Constructor that builds a w X w grid without initializing it. 
 * @param width  the grid 
 */
public World(int w){
    grid = new Living[w][w];
    width = w;}
       
public int getWidth(){
    return width;}
    
/**
 * Initialize the world by randomly assigning to every square of the grid  
 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.
 */
public void randomInit(){
    int r = 0,c = 0;
    Random generator = new Random();
    for(r = 0;r < width;++r){
	for(c = 0;c < width;++c){
	    int lifeval = generator.nextInt(100);
	    if(lifeval < 10){
		this.grid[r][c] = new Badger(this,r,c,0);}
	    else if(lifeval < 20){
		this.grid[r][c] = new Fox(this,r,c,0);}
	    else if(lifeval < 50){
		this.grid[r][c] = new Rabbit(this,r,c,0);}
	    else if(lifeval < 80){
		this.grid[r][c] = new Grass(this,r,c);}
	    else
		this.grid[r][c] = new Empty(this,r,c);
	    ++c;}
	++r;}	    
}
	
	
/**
 * Write the world grid as a string according to the output format.
 */
@Override
public String toString(){
    String visRep = "";

    for(int r = 0;r < width;++r){
	for(int c = 0;c < width;++c){
	    if(this.grid[r][c] == null)
		System.out.println("Null Here");
	    else{
		switch((this.grid[r][c]).who()){
		case EMPTY: visRep += "E ";
		    break;
		case GRASS: visRep += "G ";
		    break;
		case RABBIT: visRep += "R ";
		    break;
		case FOX: visRep += "F ";
		    break;
		case BADGER: visRep += "B ";
		    break;}}}
	visRep += "\n";}
    return visRep;}
	
/**
 * Write the world grid to an output file.  Useful for a randomly generated world. 
 * @throws FileNotFoundException
 */
public void write(String outputFileName) throws FileNotFoundException{
    try{
	PrintWriter writer = new PrintWriter(outputFileName, "UTF-8");
	writer.println(this.toString());
	writer.close();}

    catch (IOException e){
	System.out.println("File not found.");}}}
