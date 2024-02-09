import java.util.Arrays;

public class State {
    private char[][][] cube;
  

	public State(char[][][] cube) {
		super();
		this.cube = cube;
	}


	


	public char[][][] getCube() {
		return cube;
	}





	public void setCube(char[][][] cube) {
		this.cube = cube;
	}





	@Override
	public String toString() {
		String cubeFaces="";
		for (int face = 0; face < cube.length; face++) {
			cubeFaces+="Face " + (face + 1) + ":\n";
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
