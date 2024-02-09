
public class Main {

	public static void main(String[] args) {
		 char[][][] GoalCube = new char[][][]{
             {{'R', 'W'}, {'W', 'W'}}, // Top
             {{'R', 'R'}, {'R', 'R'}}, // Front
             {{'B', 'B'}, {'B', 'B'}}, // Right
             {{'O', 'O'}, {'O', 'O'}}, // Back
             {{'G', 'G'}, {'G', 'G'}}, // Left
             {{'Y', 'Y'}, {'Y', 'Y'}}  // Bottom
         };
         State s = new State(GoalCube);
         System.out.println(s.toString());
         System.out.println(isGoal(s));
         rotateFrontClockwise(GoalCube, 'U');
         System.out.println(s.toString());
         

	}
	public static Boolean isGoal(State S) {
		Boolean flag = true;
    	 char[][][] GoalCube = new char[][][]{
             {{'W', 'W'}, {'W', 'W'}}, // Top
             {{'R', 'R'}, {'R', 'R'}}, // Front
             {{'B', 'B'}, {'B', 'B'}}, // Right
             {{'O', 'O'}, {'O', 'O'}}, // Back
             {{'G', 'G'}, {'G', 'G'}}, // Left
             {{'Y', 'Y'}, {'Y', 'Y'}}  // Bottom
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
	static char[][][] rotateFrontClockwise(char[][][] state , char move) {
		
        switch (move) {
        	case 'U':
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                        if(face ==0 && row == 0 && col == 0) {	
                        	char i = state[face][row][col];	
                          state[face][row][col] = state[face][row+1][col];// 0 => 2
                          state[face][row+1][col] =i;//2 => 0
                        
                            
                        }
                        }
    
                        
                    }

                }
        		
        }	
        return state;
    }


}
