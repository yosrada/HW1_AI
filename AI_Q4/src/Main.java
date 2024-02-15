import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);

        String userInput = "";
        do {
            // Prompt the user to enter a string
        	if(userInput!="") {
                System.out.print("You must inter a valid string that contain  R,B,O,G,Y,W and the length is 24");

        	}
            System.out.println("Enter your current state as a string (type 'quit' to exit): ");

            // Read the string entered by the user
            userInput = scanner.nextLine();
            if(userInput.equals("quit")) {
            	System.out.println("GoodBye");
            	System.exit(0);
            }

        } while ( !isValidString(userInput)||userInput.length()!=24 || !isValidInput(userInput) );
        
        System.out.println("Do you want Dfs algorthim ? YES or NO  ");
        String algorthim = scanner.nextLine();
        char[][][] inputCube;
        if (algorthim.equals("YES")) {
 		    inputCube = createCube(userInput);
 	        scanner.close();
 	        State initialState = new State(inputCube); 	      
 	     
 	         Set<String> visited = new HashSet<String>();
 	         List<String> solutionMoves = depthLimitedDFS(initialState, visited , 0 , 15); //we limited the algorthim by depth 
 	         if (solutionMoves != null) {
 	             System.out.println("Solution found! Moves: " + solutionMoves);
 	             System.out.println("\n - the count of the moves :"+ solutionMoves.size());
             	System.out.println("GoodBye");
 	             System.exit(0);
 	         } else {
 	             System.out.println("No solution found.");
             	System.out.println("GoodBye");
 	             System.exit(0);
 	         }
        }
      

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
                     if(face == 5 && row ==0 && col ==0 ) {
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
	public static boolean isValidInput(String input) {
	    for (int i = 0; i < input.length(); i++) {
	        char c = input.charAt(i);
	        if (!Character.isUpperCase(c) || !Character.isLetter(c)) {
	            // If any character is not an uppercase letter, return false
	            return false;
	        }
	    }
	    // If all characters are uppercase letters, return true
	    return true;
	}
	 public static boolean isValidString(String input) {	        //Count occurrences of each letter in the input string- Check if each letter count is exactly four
	        int countW = 0, countR = 0, countG = 0, countY = 0, countO = 0, countB = 0;

	        for (char c : input.toCharArray()) {
	            switch (c) {
	                case 'W':
	                    countW++;
	                    break;
	                case 'R':
	                    countR++;
	                    break;
	                case 'G':
	                    countG++;
	                    break;
	                case 'Y':
	                    countY++;
	                    break;
	                case 'O':
	                    countO++;
	                    break;
	                case 'B':
	                    countB++;
	                    break;
	                default:
	                    // Ignore other characters
	                    break;
	            }
	        }
	        return countW == 4 && countR == 4 && countG == 4 && countY == 4 && countO == 4 && countB == 4;
	    }
	 
	  public static char[][][] createCube(String input) { //fill the cube array -
	        char[][][] cube = new char[6][2][2]; // 
	        int faceIndex = 0;
	        int charIndex = 0;

	        // Iterate through the input string
	        for (int i = 0; i < input.length(); i++) {
	            char c = input.charAt(i);
	            cube[faceIndex][charIndex / 2][charIndex % 2] = c;

	            charIndex++;

	            if (charIndex == 4) {
	                faceIndex++;
	                charIndex = 0;
	            }
	        }

	        return cube;
	    }
	


	}