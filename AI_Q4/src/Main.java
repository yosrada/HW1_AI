import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		   char[][][] inputCube = {
		            {{'W' , 'W' }, {'W', 'W'}}, // Top
		            {{'R', 'R'}, {'R', 'R'}}, // Front
		            {{'G', 'G'}, {'G', 'G'}}, // Right
		            {{'Y', 'Y'}, {'Y', 'Y'}}, // Back
		            {{'O', 'O'}, {'O', 'O'}}, // Left
		            {{'B', 'B'}, {'B', 'B'}}  // Bottom
		        };

		   
        State initialState = new State(inputCube);
        System.out.println(isGoal(initialState));
        
//		        Set<String> visited = new HashSet<>();
//		        int maxDepth = 3; // You can adjust this based on your requirements
//
//		        // Call the DFS function with the initial depth of 0 and the maximum depth
//		        List<String> solutionMoves = iterativeDeepeningDFS(initialState, maxDepth);
//                
//		        if (solutionMoves != null) {
//		            System.out.println("Solution found! Moves: " + solutionMoves);
//		        } else {
//		            System.out.println("No solution found.");
//		        }
//		    
       
     initialState.setCube(rotateFrontClockwise(initialState.getCube(), "R")); 
     initialState.setCube(rotateFrontClockwise(initialState.getCube(), "B")); 
     initialState.setCube(rotateFrontClockwise(initialState.getCube(), "F")); 
     initialState.setCube(rotateFrontClockwise(initialState.getCube(), "F")); 
     initialState.setCube(rotateFrontClockwise(initialState.getCube(), "F")); 
     initialState.setCube(rotateFrontClockwise(initialState.getCube(), "U")); 
     System.out.println(isGoal(initialState));
     
       for (int face = 0; face < initialState.getCube().length; face++) {
           System.out.println(  " face: " +face );
           for (int row = 0; row < inputCube[face].length; row++) {
               for (int col = 0; col < inputCube[face][row].length; col++) {
                   System.out.print(inputCube[face][row][col] + " ");
               }
               System.out.println(); // Move to the next line after printing each row
           }
           System.out.println(); // Extra line for spacing between faces
       }

       
//         Set<String> visited = new HashSet<String>();
//         List<String> solutionMoves = depthLimitedDFS(initialState, visited , 0 , 5);
//         if (solutionMoves != null) {
//             System.out.println("Solution found! Moves: " + solutionMoves);
//         } else {
//             System.out.println("No solution found.");
//         }

	}

		
	//goal function
	public static Boolean isFaceUniform(char[][] face ) {
		// Get the first character of the face to compare with others
	    char firstChar = face[0][0];
	    
	    // Iterate through each cell of the face
	    for (int i = 0; i <face.length; i++) {
	        for (int j = 0; j < face.length; j++) {
	            // If any character does not match the first character, return false
	            if (face[i][j]!= firstChar) {
	                return false;
	            }
	        }
	    }
	    
	    // If we get here, all characters matched; the face is uniform
	    return true;
   }
	
	static boolean isGoal(State s) {
	    // Iterate through each face of the cube
	    for (int i = 0; i < s.getCube().length;i++) {
	        if (!isFaceUniform(s.getCube()[i])){
	            return false;
	        }
	    }
	    
	    return true;
	}
	
	//successor function
	static ArrayList<char[][][]> SuccessorFunction(char[][][] state){
		ArrayList<char[][][]> statesList = new ArrayList<>();
		char [][][] nextStates;
		String[] moves = {"F","R","U","B","L","D","F`","R`","U`","B`","L`","D`"};
		for(int i = 0 ; i <moves.length ; i++) {
			nextStates = rotateFrontClockwise(state, moves[i]);
		//	charNextStates = convertToChar(nextStates);
			statesList.add(nextStates);
		}
	
		return statesList;
	}
	
	//moves function
	static char[][][] rotateFrontClockwise(char[][][] state , String move) {
            
        switch (move) {
        	case "U":
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                        if(face ==0 && row == 0 && col == 0) {	//face 0 
                          char i = state[face][row][col];	
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
                     	char[] pair = state[face][row];
                     	state[face][row] =state[face+4][row] ;
                     	state[face+4][row] = pair;
                     	
                     	 
                     }
                     if(face == 2 && row ==0 && col ==0 ) {
                     	char[] pair = state[face][row];
                     	state[face][row] =state[face+2][row] ;
                     	state[face+2][row] = pair;
                     	 
                     }
                     if(face == 4 && row ==0 && col ==0 ) {
                     	char[] pair = state[face][row];
                     	state[face][row] =state[face-3][row] ;
                     	state[face-3][row] = pair;
                     }
                  
                     }
 
                     
                 }

             
			
                }break;
        	case "D":
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                        if(face == 1 && row ==1 && col ==0 ) {
                        	char[] pair = state[face][row];
                        	state[face][row] =state[face+4][row] ;
                        	state[face+4][row] = pair;
                        	 
                        }
                        if(face == 2 && row ==1 && col ==0 ) {
                        	char[] pair = state[face][row];
                        	state[face][row] =state[face+2][row] ;
                        	state[face+2][row] = pair;
                        	 
                        }
                        if(face == 4 && row ==1 && col ==0 ) {
                        	char[] pair = state[face][row];
                        	state[face][row] =state[face-3][row] ;
                        	state[face-3][row] = pair;
                        }
                        if(face ==3 && row == 0 && col == 0) {	//face 0 
                            char i = state[face][row][col];	
                            state[face][row][col] = state[face][row][col+1];// 0 => 2
                            state[face][row][col+1] = i ; 
                            i = state[face][row+1][col];
                            state[face][row+1][col] = state[face][row+1][col+1];
                            state[face][row+1][col+1] = i ;
                            i = state[face][row][col] ; 
                            state[face][row][col] = state[face][row+1][col+1] ;
                            state[face][row+1][col+1] = i ; 
                           

                          }
                     
                        }
    
                        
                    }

                }break;
                
                
        	case "R" : 
        		   for (int face = 0; face < state.length; face++) {
                       // Iterate through each row of the face
                       for (int row = 0; row < state[face].length; row++) {
                           // Iterate through each column of the face
                           for (int col = 0; col < state[face][row].length; col++) {
                               if(face ==0 && row == 0 && col == 0) {
                            	   char i = state[face][row][col+1];
                            	   state[face][row][col+1] = state[face+2][row][col+1];
                            	   state[face+2][row][col+1] = i;
                            	    i = state[face][row+1][col+1];
                            	   state[face][row+1][col+1] =   state[face+2][row+1][col+1];
                            	   state[face+2][row+1][col+1] = i;
                               }
                               if(face ==1 && row ==0 && col == 0 ) {
                            	   char i = state[face][row][col];
                            	   state[face][row][col] = state[face][row][col+1];
                            	   state[face][row][col+1] = i ;
                            	    i = state[face][row+1][col];
                            	    state[face][row+1][col] = state[face][row+1][col+1];
                            	    state[face][row+1][col+1] = i;
                            	    i = state[face][row][col];
                            	    state[face][row][col] = state[face][row+1][col+1];
                            	    state[face][row+1][col+1] = i ;

                               }
                               if(face ==2 && row ==0 && col == 0 ) {
                            	   char i = state[face][row][col+1];
                            	   state[face][row][col+1] = state[face+1][row][col+1];
                            	   state[face+1][row][col+1] = i;
                            	   i = state[face][row+1][col+1];
                            	   state[face][row+1][col+1] = state[face+1][row+1][col+1];
                            	   state[face+1][row+1][col+1] = i;
                               }
                               if(face ==3 && row ==0 && col == 0) {
                            	   char i = state[face][row][col+1];
                            	   state[face][row][col+1] = state[face+2][row][col];
                            	   state[face+2][row][col] = i;
                            	   i = state[face][row+1][col+1];
                            	   state[face][row+1][col+1] = state[face+2][row+1][col];
                            	   state[face+2][row+1][col] = i;
                            	   i = state[face+2][row][col];
                            	   state[face+2][row][col]=state[face+2][row+1][col];
                            	   state[face+2][row+1][col] = i;
                            	   i = state[face][row][col+1];
                            	   state[face][row][col+1]=state[face][row+1][col+1];
                            	   state[face][row+1][col+1] = i;
                               }
                           }
       
                           
                       }

                   }break;
        	case "L":
        		  for (int face = 0; face < state.length; face++) {
                      // Iterate through each row of the face
                      for (int row = 0; row < state[face].length; row++) {
                          // Iterate through each column of the face
                          for (int col = 0; col < state[face][row].length; col++) {
                        	    if(face ==0 && row == 0 && col == 0) {
                             	   char i = state[face][row][col];
                             	   state[face][row][col] = state[face+2][row][col];
                             	   state[face+2][row][col] = i;
                             	    i = state[face][row+1][col];
                             	   state[face][row+1][col] =   state[face+2][row+1][col];
                             	   state[face+2][row+1][col] = i;
                                }
                        	    if(face ==0 && row == 0 && col == 0) {
                              	   char i = state[face][row][col];
                              	   state[face][row][col] = state[face+3][row][col];
                              	   state[face+3][row][col] = i;
                              	    i = state[face][row+1][col];
                              	   state[face][row+1][col] =   state[face+3][row+1][col];
                              	   state[face+3][row+1][col] = i;
                              	   
                                 }
                        	    if(face ==0 && row == 0 && col == 0) {
                               	   char i = state[face][row][col];
                               	   state[face][row][col] = state[face+5][row][col+1];
                               	   state[face+5][row][col+1] = i;
                               	    i = state[face][row+1][col];
                               	   state[face][row+1][col] =   state[face+5][row+1][col+1];
                               	   state[face+5][row+1][col+1] = i;
                               	 i = state[face][row][col];
                               	  state[face][row][col]=state[face][row+1][col];
                             	   state[face][row+1][col] = i;
                             		 i = state[face+5][row][col+1];
                                  	  state[face+5][row][col+1]=state[face+5][row+1][col+1];
                                	   state[face+5][row+1][col+1] = i;
                             	   
                                   }
                        	    if(face ==4 && row ==0 && col == 0) {
                             	   char i = state[face][row][col];
                             	   state[face][row][col] = state[face][row][col+1];
                             	   state[face][row][col+1] = i;
                             	   i = state[face][row+1][col];
                             	   state[face][row+1][col] = state[face][row+1][col+1];
                             	   state[face][row+1][col+1] = i;
                             	   i = state[face][row][col];
                             	   state[face][row][col]=state[face][row+1][col+1];
                             	   state[face][row+1][col+1] = i;
                                }
                       }
      
                          
                      }

                  }break;
        	case "F" : 
     		   for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                            if(face ==0 && row == 0 && col == 0) {
                         	   char i = state[face][row+1][col];
                         	   state[face][row+1][col] = state[face+1][row][col];
                         	   state[face+1][row][col] = i;
                         	    i = state[face][row+1][col+1];
                         	   state[face][row+1][col+1] =   state[face+1][row+1][col];
                         	   state[face+1][row+1][col] = i;
                         	   
                            }
                            if(face ==3 && row == 0 && col == 0) {
                          	   char i = state[face][row][col];
                          	   state[face][row][col] = state[face+1][row][col+1];
                          	   state[face+1][row][col+1] = i;
                          	    i = state[face][row][col+1];
                          	   state[face][row][col+1] =   state[face+1][row+1][col+1];
                          	   state[face+1][row+1][col+1] = i;
                          	   //////
                            	  i = state[face-3][row+1][col];
                              	 state[face-3][row+1][col] =  state[face][row][col+1];
                              	 state[face][row][col+1] =i ; 
                                 i = state[face-3][row+1][col+1];
                                 state[face-3][row+1][col+1] = state[face][row][col];
                                 state[face][row][col] = i ;
                          	   
                             }
                            if(face == 5 && row == 0 && col == 0 ) {
                            	char i = state[face-3][row][col];
                            	state[face-3][row][col] = state[face-3][row][col+1]; 
                            	state[face-3][row][col+1] = i;
                            	 i = state[face-3][row+1][col];
                            	 state[face-3][row+1][col] = state[face-3][row+1][col+1];
                            	 state[face-3][row+1][col+1] = i ; 
                            	 i = state[face-3][row][col];
                            	 state[face-3][row][col] = state[face-3][row+1][col+1];
                            	 state[face-3][row+1][col+1] = i ; 
                            }


                        }
                    }		

                }break;
        	case "B":
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                          if (face == 0 && row == 0 && col ==0) {
                        	  char i = state[face][row][col+1];
                        	  state[face][row][col+1] = state[face+4][row][col];
                        	  state[face+4][row][col] = i;
                        	  i = state[face][row][col];
                        	  state[face][row][col] = state[face+4][row+1][col];
                        	  state[face+4][row+1][col] = i ; 
                          }
                          if(face == 1 && row == 0 && col == 0) {
                        	  char i = state[face][row][col+1];
                        	  state[face][row][col+1] = state[face+2][row+1][col+1];
                        	  state[face+2][row+1][col+1] = i ;
                        	  i = state[face][row+1][col+1];
                        	  state[face][row+1][col+1] = state[face+2][row+1][col];
                        	  state[face+2][row+1][col] = i ;
                          }
                          if(face == 3 && row ==0 && col == 0 ) {
                        	  char i = state[face][row+1][col+1];
                        	  state[face][row+1][col+1] = state[face-3][row][col];
                        	  state[face-3][row][col] = i ;
                        	   i = state[face][row+1][col];
                        	  state[face][row+1][col] = state[face-3][row][col+1];
                        	  state[face-3][row][col+1] = i ;
     	
                          }
                          
                          if(face ==5 && row ==0 && col == 0) {
                        	   char i = state[face][row][col];
                        	   state[face][row][col] = state[face][row][col+1];
                        	   state[face][row][col+1] = i;
                        	   i = state[face][row+1][col];
                        	   state[face][row+1][col] = state[face][row+1][col+1];
                        	   state[face][row+1][col+1] = i;
                        	   i = state[face][row][col];
                        	   state[face][row][col]=state[face][row+1][col+1];
                        	   state[face][row+1][col+1] = i;
                           }
                        }
    
                        
                    }

                }break;
                  
        	case "U`":
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                        if(face ==0 && row == 0 && col == 0) {	//face 0 
                          char i = state[face][row][col];	
                          state[face][row][col] = state[face][row][col+1];
                          state[face][row][col+1] = i ; 
                          i = state[face][row+1][col];
                          state[face][row+1][col] = state[face][row+1][col+1];
                          state[face][row+1][col+1] = i ;
                          i = state[face][row][col+1] ; 
                          state[face][row][col+1] = state[face][row+1][col] ;
                          state[face][row+1][col] = i ; 
                         

                        }
                        if(face == 1 && row ==0 && col ==0 ) {
                        	char[] pair = state[face][row];
                        	state[face][row] =state[face+4][row] ;
                        	state[face+4][row] = pair;
                        	
                        	 
                        }
                        if(face == 2 && row ==0 && col ==0 ) {
                        	char[] pair = state[face][row];
                        	state[face][row] =state[face+2][row] ;
                        	state[face+2][row] = pair;
                        	 
                        }
                        if(face == 4 && row ==0 && col ==0 ) {
                        	char[] pair = state[face][row];
                        	state[face][row] =state[face-3][row] ;
                        	state[face-3][row] = pair;
                        }
                     
                        }
    
                        
                    }

                }break;
        	case "F`":
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                        if(face ==0 && row == 0 && col == 0) {	//face 0 
                        	char temp = state[face][row+1][col];
                        	char temp1 = state[face][row+1][col+1];
                        	state[face][row+1][col] = state[face+1][row][col];
                        	state[face][row+1][col+1]=state[face+1][row+1][col];
                        	state[face+1][row][col]=temp;
                        	state[face+1][row+1][col] = temp1;
                        	
                        }
                        if(face == 1 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col];
                        	char temp1 = state[face][row+1][col];
                        	state[face][row][col] = state[face+3][row+1][col+1];
                        	state[face][row+1][col]=state[face+3][row][col+1];
                        	state[face+3][row+1][col+1]=temp;
                        	state[face+3][row][col+1] = temp1;
                        	
                        	 
                        }
                        if(face == 2 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col];
                        	state[face][row][col] = state[face][row][col+1];
                        	state[face][row][col+1] = temp;
                        	temp = state[face][row+1][col+1];
                        	state[face][row+1][col+1]=state[face][row+1][col];
                        	state[face][row+1][col]=temp;
                        	temp = state[face][row][col+1];
                        	state[face][row][col+1] = state[face][row+1][col];
                        	state[face][row+1][col] = temp;

                        }
                        if(face == 3 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col];
                        	char temp1 = state[face][row][col+1];
                        	state[face][row][col] = state[face-2][row+1][col];
                        	state[face][row][col+1]=state[face-2][row][col];
                        	state[face-2][row+1][col]=temp;
                        	state[face-2][row][col] = temp1;
                        	 
                        }

                     
                        }
    
                        
                    }

                }break;
        	case "R`":
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                        if(face ==0 && row == 0 && col == 0) {	//face 0 
                        	char temp = state[face][row][col+1];
                        	char temp1 = state[face][row+1][col+1];
                        	state[face][row][col+1] = state[face+5][row+1][col];
                        	state[face][row+1][col+1]=state[face+5][row][col];
                        	state[face+5][row+1][col]=temp1;
                        	state[face+5][row][col] = temp;
                        	
                        }
                        if(face == 1 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col];
                        	state[face][row][col] = state[face][row][col+1];
                        	state[face][row][col+1] = temp;
                        	temp = state[face][row+1][col+1];
                        	state[face][row+1][col+1]=state[face][row+1][col];
                        	state[face][row+1][col]=temp;
                        	temp = state[face][row][col+1];
                        	state[face][row][col+1] = state[face][row+1][col];
                        	state[face][row+1][col] = temp;

                        }
                        if(face == 2 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col+1];
                        	char temp1 = state[face][row+1][col+1];
                        	state[face][row][col+1] = state[face+3][row][col];
                        	state[face][row+1][col+1]=state[face+3][row+1][col];
                        	state[face+3][row][col]=temp;
                        	state[face+3][row+1][col] = temp1;
                        	
                        	 
                        }

                        if(face == 3 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col+1];
                        	char temp1 = state[face][row+1][col+1];
                        	state[face][row][col+1] = state[face+2][row][col];
                        	state[face][row+1][col+1]=state[face+2][row+1][col];
                        	state[face+2][row+1][col]=temp;
                        	state[face+2][row][col] = temp1;
                        	 
                        }

                     
                        }
    
                        
                    }

                }break;
        	case "B`":
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                        if(face ==0 && row == 0 && col == 0) {	//face 0 
                        	char temp = state[face][row][col];
                        	char temp1 = state[face][row][col+1];
                        	state[face][row][col] = state[face+4][row+1][col];
                        	state[face][row][col+1]=state[face+4][row][col];
                        	state[face+4][row+1][col]=temp;
                        	state[face+4][row][col] = temp1;
                        	
                        }
                        if(face == 1 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col+1];
                        	char temp1 = state[face][row+1][col+1];
                        	state[face][row][col+1] = state[face+3][row+1][col];
                        	state[face][row+1][col+1]=state[face+3][row][col];
                        	state[face+3][row+1][col]=temp;
                        	state[face+3][row][col] = temp1;
                        	
                        	 
                        }
                        if(face == 3 && row ==0 && col ==0 ) {
                        	char temp = state[face][row+1][col];
                        	char temp1 = state[face][row+1][col+1];
                        	state[face][row+1][col] = state[face+1][row][col];
                        	state[face][row+1][col+1]=state[face+1][row+1][col];
                        	state[face+1][row][col]=temp;
                        	state[face+1][row+1][col] = temp1;
                        	 
                        }
                        if(face == 5 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col];
                        	state[face][row][col] = state[face][row][col+1];
                        	state[face][row][col+1] = temp;
                        	temp = state[face][row+1][col+1];
                        	state[face][row+1][col+1]=state[face][row+1][col];
                        	state[face][row+1][col]=temp;
                        	temp = state[face][row][col+1];
                        	state[face][row][col+1] = state[face][row+1][col];
                        	state[face][row+1][col] = temp;

                        }



                     
                        }
    
                        
                    }

                }break;

        	case "D`":
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                        	if(face == 1 && row ==1 && col ==0 ) {
                        		char[] pair = state[face][row];
                            	state[face][row] =state[face+4][row] ;
                            	state[face+4][row] = pair;
                            	 
                            }
                            if(face == 2 && row ==1 && col ==0 ) {
                            	char[] pair = state[face][row];
                            	state[face][row] =state[face+3][row] ;
                            	state[face+3][row] = pair;
                            	 
                            }
                            if(face == 4 && row ==1 && col ==0 ) {
                            	char[] pair = state[face][row];
                            	state[face][row] =state[face+1][row] ;
                            	state[face+1][row] = pair;
                            }
                        if(face == 3 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col];
                        	state[face][row][col] = state[face][row][col+1];
                        	state[face][row][col+1] = temp;
                        	temp = state[face][row+1][col+1];
                        	state[face][row+1][col+1]=state[face][row+1][col];
                        	state[face][row+1][col]=temp;
                        	temp = state[face][row][col+1];
                        	state[face][row][col+1] = state[face][row+1][col];
                        	state[face][row+1][col] = temp;

                        }



                     
                        }
    
                        
                    }

                }break;
        	case "L`":
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                        if(face ==1)
                        	break;
                        if(face ==0 && row == 0 && col == 0) {	//face 0 
                        	char temp = state[face][row][col];
                        	char temp1 = state[face][row+1][col];
                        	state[face][row][col] = state[face+2][row][col];
                        	state[face][row+1][col]=state[face+2][row+1][col];
                        	state[face+2][row][col]=temp;
                        	state[face+2][row+1][col] = temp1;
                        	
                        }
                        if(face == 2 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col];
                        	char temp1 = state[face][row+1][col];
                        	state[face][row][col] = state[face+1][row][col];
                        	state[face][row+1][col]=state[face+1][row+1][col];
                        	state[face+1][row][col]=temp;
                        	state[face+1][row+1][col] = temp1;
                        	
                        	 
                        }
                        if(face == 3 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col];
                        	char temp1 = state[face][row+1][col];
                        	state[face][row][col] = state[face+2][row+1][col+1];
                        	state[face][row+1][col]=state[face+2][row][col+1];
                        	state[face+2][row+1][col+1]=temp;
                        	state[face+2][row][col+1] = temp1;
                        	 
                        }
                        if(face == 4 && row ==0 && col ==0 ) {
                        	char temp = state[face][row][col];
                        	state[face][row][col] = state[face][row][col+1];
                        	state[face][row][col+1] = temp;
                        	temp = state[face][row+1][col+1];
                        	state[face][row+1][col+1]=state[face][row+1][col];
                        	state[face][row+1][col]=temp;
                        	temp = state[face][row][col+1];
                        	state[face][row][col+1] = state[face][row+1][col];
                        	state[face][row+1][col] = temp;

                        }



                     
                        }
    
                        
                    }

                } break; 
            
        		
              
        		
        }

        return state;
    }
	
	public static List<String> depthLimitedDFS(State cube, Set<String> visited, int depth, int maxDepth) {
	   
		if (depth > maxDepth) {
	        return null; // Exceeded maximum depth
	    }

	    if (isGoal(cube)) {
	    	System.out.println("isGoal if ");
	        return cube.getMoves(); // Goal state reached
	    }

	    String cubeId = cube.stateIdentifier();
	    if (visited.contains(cubeId)) {
	        return null; // Already visited this state
	    }
	    visited.add(cubeId);

	    String[] possibleMoves = {"F", "R", "U", "B", "L", "D", "F`", "R`", "U`", "B`", "L`", "D`"};
	    for (String move : possibleMoves) {
	        State newCube = cube.cloneCube();
	        rotateFrontClockwise(newCube.getCube(), move);
	        newCube.getMoves().add(move);
	        List<String> result = depthLimitedDFS(newCube, new HashSet<>(visited), depth + 1, maxDepth);
	        if (result != null) {
	            return result; // Found a solution
	        }
	    }

	    return null; // No solution found within this depth limit
	}
	
	
	public static List<String> iterativeDeepeningDFS(State initialState, int maxDepth) {
	    for (int depth = 1; depth <= maxDepth; depth++) {
	        Set<String> visited = new HashSet<>(); // Reset visited states for each depth limit
	        List<String> result = depthLimitedDFS(initialState, visited, 0, depth);
	        if (result != null) {
	            return result; // Solution found
	        }
	    }
	    return null; // No solution found within the maximum depth
	}


	}