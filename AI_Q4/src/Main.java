
public class Main {

	public static void main(String[] args) {
		 int[][][] GoalCube = new int[][][]{
             {{0 , 1 }, {2,3}}, // Top
             {{4,5}, {6,7}}, // Front
             {{8,9}, {10, 11}}, // Right
             {{12, 13}, {14, 15}}, // Back
             {{16,17}, {18, 19}}, // Left
             {{20,21}, {22, 23}}  // Bottom
         };
         State s = new State(GoalCube);
         for (int[][] face : GoalCube) {
             for (int[] row : face) {
                 for (int tile : row) {
                     System.out.print(tile + " ");
                 }
             }
         }
         System.out.println("\n ******************************");
       System.out.println(s.toString());
     //    System.out.println(isGoal(s));
        rotateFrontClockwise(GoalCube, 'U');
         System.out.println(s.toString());
         for (int[][] face : GoalCube) {
             for (int[] row : face) {
                 for (int tile : row) {
                     System.out.print(tile + " ");
                 }
             }
         }
         
      

	}
	public static Boolean isGoal(State S) {
		Boolean flag = true;
		 int[][][] GoalCube = new int[][][]{
             {{0 , 1 }, {2,3}}, // Top
             {{4,5}, {6,7}}, // Front
             {{8,9}, {10, 11}}, // Right
             {{12, 13}, {14, 15}}, // Back
             {{16,17}, {18, 19}}, // Left
             {{20,21}, {22, 23}}  // Bottom
         };
         for (int face = 0; face < S.getCube().length; face++) {
             // Iterate through each row of the face
             for (int row = 0; row < S.getCube()[face].length; row++) {
                 // Iterate through each column of the face
                 for (int col = 0; col < S.getCube()[face][row].length; col++) {
                     if(!(GoalCube[face][row][col] ==S.getCube()[face][row][col])) {
                    	 flag = false;
                    	 break;
                     }
                     
                 }
                 if (flag == false)
                	 break;
                 
             }
             if (flag == false)
            	 break;
         }
         return flag;
    }
	static int[][][] rotateFrontClockwise(int[][][] state , char move) {
		
        switch (move) {
        	case 'U':
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                        if(face ==0 && row == 0 && col == 0) {	//face 0 
                          int i = state[face][row][col];	
                          state[face][row][col] = state[face][row][col+1];// 0 => 2
                          state[face][row][col+1] = i ; 
                          i = state[face][row+1][col];
                          state[face][row+1][col] = state[face][row+1][col+1];
                          state[face][row+1][col+1] = i ;
                          i = state[face][row][col] ; 
                          state[face][row][col] = state[face][row+1][col+1] ;
                          state[face][row+1][col+1] = i ; 
                         

                        }
                        if(face == 1 && row ==0 && col ==0 ) {
                        	int[] pair = state[face][row];
                        	state[face][row] =state[face+4][row] ;
                        	state[face+4][row] = pair;
                        	 
                        }
                        if(face == 2 && row ==0 && col ==0 ) {
                        	int[] pair = state[face][row];
                        	state[face][row] =state[face+2][row] ;
                        	state[face+2][row] = pair;
                        	 
                        }
                        if(face == 2 && row ==0 && col ==0 ) {
                        	int[] pair = state[face][row];
                        	state[face][row] =state[face+3][row] ;
                        	state[face+3][row] = pair;
                        }
                     
                        }
    
                        
                    }

                }
        		
        }	
        return state;
    }
}


