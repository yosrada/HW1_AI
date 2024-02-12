import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class State {
    private int[][][] cube;
    private ArrayList<String> moves;

	public State(int[][][] cube) {
		super();
		this.cube = cube;
		this.moves = new ArrayList<>();
		}


	


	public ArrayList<String> getMoves() {
		return moves;
	}





	public void setMoves(ArrayList<String> moves) {
		this.moves = moves;
	}





	public int[][][] getCube() {
		return cube;
	}





	public void setCube(int[][][] cube) {
		this.cube = cube;
	}





	@Override
	public String toString() {
		String cubeFaces="";
		for (int face = 0; face < cube.length; face++) {
			cubeFaces+="Face " + (face ) + ":\n";
	        // Iterate through each row of the face
	        for (int row = 0; row < cube[face].length; row++) {
	            // Iterate through each column of the face
	            for (int col = 0; col < cube[face][row].length; col++) {
	            	cubeFaces+=cube[face][row][col] + " ";
	            }
	        }
	        cubeFaces+="\n";
	    }
		return cubeFaces;
	}



   /* public RubiksCube2x2() {
        // Initialize each face with its respective color
        cube = new char[][][]{
            {{'W', 'W'}, {'W', 'W'}}, // Top
            {{'R', 'R'}, {'R', 'R'}}, // Front
            {{'B', 'B'}, {'B', 'B'}}, // Right
            {{'O', 'O'}, {'O', 'O'}}, // Back
            {{'G', 'G'}, {'G', 'G'}}, // Left
            {{'Y', 'Y'}, {'Y', 'Y'}}  // Bottom
        };
    }*/


}
