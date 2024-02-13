import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Arrays;

public class State {
    private char[][][] cube;
    private ArrayList<String> moves;

    public State(char[][][] cube) {
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

    public char[][][] getCube() {
        return cube;
    }

    public void setCube(char[][][] cube) {
        this.cube = cube;
    }

    // Deep clone the cube array
    public State cloneCube() {
        char[][][] newCube = new char[cube.length][][];
        for (int i = 0; i < cube.length; i++) {
            newCube[i] = new char[cube[i].length][];
            for (int j = 0; j < cube[i].length; j++) {
                newCube[i][j] = cube[i][j].clone();
            }
        }
        State newState = new State(newCube);
        newState.setMoves(new ArrayList<>(this.moves)); // Also clone the moves if necessary
        return newState;
    }

    public String stateIdentifier() {
        StringBuilder identifier = new StringBuilder();
        for (char[][] face : cube) {
            for (char[] row : face) {
                for (char tile : row) {
                    identifier.append(tile);
                }
            }
        }
        return identifier.toString();
    }



    @Override
    public String toString() {
        String cubeFaces = "";
        for (int face = 0; face < cube.length; face++) {
            cubeFaces += "Face " + (face) + ":\n";
            for (char[] row : cube[face]) {
                for (int tile : row) {
                    cubeFaces += tile + " ";
                }
                cubeFaces += "\n";
            }
        }
        return cubeFaces;
    }
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



