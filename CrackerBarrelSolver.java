// Assignment 7 - Cracker Barrel Puzzle Solver
// Connor Harvey

import java.io.*;
import java.util.*;

public class CrackerBarrelSolver{

	// Program does not fully populate the solution arraylist, therefore solution set is never printed out step by step because the size remains 0

	public static int[][] moves = {
		{0,1,3},{0,2,5},{1,3,6},{1,4,8},{2,4,7},
		{3,1,0},{5,2,0},{5,3,1},{8,4,1},{7,4,2},
		{2,5,9},{3,6,10},{3,7,12},{4,7,11},{4,8,13},
		{9,5,2},{10,6,3},{12,7,3},{11,7,4},{13,8,4},
		{5,8,12},{5,9,14},{3,4,5},{6,7,8},{7,8,9},
		{12,8,5},{14,9,5},{5,4,3},{8,7,6},{9,8,7},
		{10,11,12},{11,12,13},{12,13,14},
		{12,11,10},{13,12,11},{14,13,12}
	};

	public static void main(String[] args){
		// default puzzle configuration
		int[] puzzle = {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

		// ArrayLists for the moves made and the remaining possible moves
		ArrayList<int[]> tempMoves = new ArrayList<int[]>();
		ArrayList<int[]> remainingMoves = new ArrayList<int[]>();

		// Populating the remainingMoves list
		for(int i = 0; i < 36; i++){
			remainingMoves.add(moves[i]);
		}

		// counting number of moves made
		int moveCount = 0;

		// setting the solution to the eventual full set of moves
		ArrayList<int[]> solved = makeMove(puzzle, tempMoves, remainingMoves, moveCount);
		printSolution(solved);
	}
	// makes the next move if possible or returns the solution set if finished
	// takes the puzzle, moves so far, remaining possible moves, and number of moves
	public static ArrayList<int[]> makeMove(int[] p, ArrayList<int[]> tMoves, ArrayList<int[]> rMoves, int c){
		ArrayList<int[]> returnArray = new ArrayList<int[]>();
		if(c >= 14){
			for(int i = 0; i < 14; i++){
				returnArray.add(tMoves.get(i));
			}
		}
		else{
			ArrayList<int[]> pMoves = possibleMoves(p, rMoves);
			for(int i = 0; i < pMoves.size(); i++){
				tMoves.add(pMoves.get(i));
				c++;
				makeMove(p, tMoves, rMoves, c);
			}
		}
		return returnArray;
	}

	// Returning the list of possible moves given puzzle and remaining moves
	public static ArrayList<int[]> possibleMoves(int[] p, ArrayList<int[]> rMoves){
		// Return array
		ArrayList<int[]> returnArray = new ArrayList<int[]>();
		
		// Finding valid moves
		for(int j = 0; j < rMoves.size(); j++){
			if(p[rMoves.get(j)[0]] == 1 && p[rMoves.get(j)[1]] == 1 && p[rMoves.get(j)[2]] == 0){
				returnArray.add(rMoves.get(j));	
			}
		}

		return returnArray;
	}

	public static void printSolution(ArrayList<int[]> tMoves){
		System.out.println("Solution reached");
		int[] p = {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		printPuzzle(p);
		for(int i = 0; i < tMoves.size(); i++){
			printPuzzle(p);
			p[tMoves.get(i)[0]] = 0;
			p[tMoves.get(i)[1]] = 0;
			p[tMoves.get(i)[2]] = 1;
		}
	}
	// Printing each step of the puzzle
	public static void printPuzzle(int[] p){
		System.out.println("    " + p[0] + "    ");
		System.out.println("   " + p[1] + " " + p[2] + "   ");
		System.out.println("  " + p[3] + " " + p[4] + " " + p[5] + "  ");
		System.out.println(" " + p[6] + " " + p[7] + " " + p[8] + " " + p[9] + " ");
		System.out.println(p[10] + " " + p[11] + " " + p[12] + " " + p[13] + " " + p[14]);
	}
}
