// Assignment 7 - Cracker Barrel Puzzle Solver
// Connor Harvey

import java.io.*;
import java.util.*;

public class CrackerBarrelSolver{

	// Program crashes on runtime, couldn't fix the issue

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

		// finding and trying the possible next moves
		for(int i = 0; i < possibleMoves(puzzle, remainingMoves).size(); i++){
			tempMoves.add(possibleMoves(puzzle, remainingMoves).get(i));
			makeMove(puzzle, tempMoves, remainingMoves, moveCount);
		}
		printSolution(tempMoves);
	}
	// makes the next move if possible or returns the solution set if finished
	// takes the puzzle, moves so far, remaining possible moves, and number of moves
	public static void makeMove(int[] p, ArrayList<int[]> tMoves, ArrayList<int[]> rMoves, int c){
		// make the next move
		//makeMove(p, tMoves, rMoves, c);
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
		for(int i = 0; i < 15; i++){
			System.out.println("{" + tMoves.get(i)[0] + "," + tMoves.get(i)[1] + "," + tMoves.get(i)[2] + "}");
		}
	}
}
