
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
<<<<<<< Updated upstream
        rotateFrontClockwise(GoalCube, "D`");
=======
        rotateFrontClockwise(GoalCube, "B");
>>>>>>> Stashed changes
         System.out.println(s.toString());
         for (int[][] face : GoalCube) {
             for (int[] row : face) {
                 for (int tile : row) {
                     System.out.print(tile + " ");
                     
                 }
             }
         }
         rotateFrontClockwise(GoalCube, "L`");
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
	static int[][][] rotateFrontClockwise(int[][][] state , String move) {
<<<<<<< Updated upstream
		System.out.println(move+"***\n");
		System.out.println("im in");
		if(move=="U`") {
			 for (int face = 0; face < state.length; face++) {
                 // Iterate through each row of the face
                 for (int row = 0; row < state[face].length; row++) {
                     // Iterate through each column of the face
                     for (int col = 0; col < state[face][row].length; col++) {
                     if(face ==0 && row == 0 && col == 0) {	//face 0 
                       int i = state[face][row][col];	
                       state[face][row][col] = state[face][row][col+1];
                       state[face][row][col+1] = i ; 
                       i = state[face][row+1][col];
                       state[face][row+1][col] = state[face][row+1][col+1];
                       state[face][row+1][col+1] = i ;
                       i = state[face][row][col+1] ; 
                       state[face][row][col+1] = state[face][row+1][col] ;
                       state[face][row+1][col] = i ; 
                      
=======
		
        switch (move) {
        	case "U":
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
                         
>>>>>>> Stashed changes

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
                     if(face == 4 && row ==0 && col ==0 ) {
                     	int[] pair = state[face][row];
                     	state[face][row] =state[face-3][row] ;
                     	state[face-3][row] = pair;
                     }
                  
                     }
 
                     
                 }

             }
		}
		if(move=="F`") {
			for (int face = 0; face < state.length; face++) {
                // Iterate through each row of the face
                for (int row = 0; row < state[face].length; row++) {
                    // Iterate through each column of the face
                    for (int col = 0; col < state[face][row].length; col++) {
                    if(face ==0 && row == 0 && col == 0) {	//face 0 
                    	int temp = state[face][row+1][col];
                    	int temp1 = state[face][row+1][col+1];
                    	state[face][row+1][col] = state[face+1][row][col];
                    	state[face][row+1][col+1]=state[face+1][row+1][col];
                    	state[face+1][row][col]=temp;
                    	state[face+1][row+1][col] = temp1;
                    	
                    }
                    if(face == 1 && row ==0 && col ==0 ) {
                    	int temp = state[face][row][col];
                    	int temp1 = state[face][row+1][col];
                    	state[face][row][col] = state[face+3][row+1][col+1];
                    	state[face][row+1][col]=state[face+3][row][col+1];
                    	state[face+3][row+1][col+1]=temp;
                    	state[face+3][row][col+1] = temp1;
                    	
                    	 
                    }
                    if(face == 2 && row ==0 && col ==0 ) {
                    	int temp = state[face][row][col];
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
                    	int temp = state[face][row][col];
                    	int temp1 = state[face][row][col+1];
                    	state[face][row][col] = state[face-2][row+1][col];
                    	state[face][row][col+1]=state[face-2][row][col];
                    	state[face-2][row+1][col]=temp;
                    	state[face-2][row][col] = temp1;
                    	 
                    }

                 
                    }

                    
                }

            }
		}
		if(move=="D`") {
			for (int face = 0; face < state.length; face++) {
                // Iterate through each row of the face
                for (int row = 0; row < state[face].length; row++) {
                    // Iterate through each column of the face
                    for (int col = 0; col < state[face][row].length; col++) {
                    	if(face == 1 && row ==1 && col ==0 ) {
                        	int[] pair = state[face][row];
                        	state[face][row] =state[face+4][row] ;
                        	state[face+4][row] = pair;
                        	 
                        }
                        if(face == 2 && row ==1 && col ==0 ) {
                        	int[] pair = state[face][row];
                        	state[face][row] =state[face+3][row] ;
                        	state[face+3][row] = pair;
                        	 
                        }
                        if(face == 4 && row ==1 && col ==0 ) {
                        	int[] pair = state[face][row];
                        	state[face][row] =state[face+1][row] ;
                        	state[face+1][row] = pair;
                        }
                    if(face == 3 && row ==0 && col ==0 ) {
                    	int temp = state[face][row][col];
                    	state[face][row][col] = state[face][row][col+1];
                    	state[face][row][col+1] = temp;
                    	temp = state[face][row+1][col+1];
                    	state[face][row+1][col+1]=state[face][row+1][col];
                    	state[face][row+1][col]=temp;
                    	temp = state[face][row][col+1];
                    	state[face][row][col+1] = state[face][row+1][col];
                    	state[face][row+1][col] = temp;

                    }

<<<<<<< Updated upstream


                 
                    }

                    
                }

            }	
				}
		if(move=="L`") {
            for (int face = 0; face < state.length; face++) {
                // Iterate through each row of the face
                for (int row = 0; row < state[face].length; row++) {
                    // Iterate through each column of the face
                    for (int col = 0; col < state[face][row].length; col++) {
                    if(face ==1)
                    	break;
                    if(face ==0 && row == 0 && col == 0) {	//face 0 
                    	int temp = state[face][row][col];
                    	int temp1 = state[face][row+1][col];
                    	state[face][row][col] = state[face+2][row][col];
                    	state[face][row+1][col]=state[face+2][row+1][col];
                    	state[face+2][row][col]=temp;
                    	state[face+2][row+1][col] = temp1;
                    	
                    }
                    if(face == 2 && row ==0 && col ==0 ) {
                    	int temp = state[face][row][col];
                    	int temp1 = state[face][row+1][col];
                    	state[face][row][col] = state[face+1][row][col];
                    	state[face][row+1][col]=state[face+1][row+1][col];
                    	state[face+1][row][col]=temp;
                    	state[face+1][row+1][col] = temp1;
                    	
                    	 
                    }
                    if(face == 3 && row ==0 && col ==0 ) {
                    	int temp = state[face][row][col];
                    	int temp1 = state[face][row+1][col];
                    	state[face][row][col] = state[face+2][row+1][col+1];
                    	state[face][row+1][col]=state[face+2][row][col+1];
                    	state[face+2][row+1][col+1]=temp;
                    	state[face+2][row][col+1] = temp1;
                    	 
                    }
                    if(face == 4 && row ==0 && col ==0 ) {
                    	int temp = state[face][row][col];
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

            }
		}
		if(move=="R`") {
			for (int face = 0; face < state.length; face++) {
                // Iterate through each row of the face
                for (int row = 0; row < state[face].length; row++) {
                    // Iterate through each column of the face
                    for (int col = 0; col < state[face][row].length; col++) {
                    if(face ==0 && row == 0 && col == 0) {	//face 0 
                    	int temp = state[face][row][col+1];
                    	int temp1 = state[face][row+1][col+1];
                    	state[face][row][col+1] = state[face+5][row+1][col];
                    	state[face][row+1][col+1]=state[face+5][row][col];
                    	state[face+5][row+1][col]=temp1;
                    	state[face+5][row][col] = temp;
                    	
                    }
                    if(face == 1 && row ==0 && col ==0 ) {
                    	int temp = state[face][row][col];
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
                    	int temp = state[face][row][col+1];
                    	int temp1 = state[face][row+1][col+1];
                    	state[face][row][col+1] = state[face+3][row][col];
                    	state[face][row+1][col+1]=state[face+3][row+1][col];
                    	state[face+3][row][col]=temp;
                    	state[face+3][row+1][col] = temp1;
                    	
                    	 
                    }

                    if(face == 3 && row ==0 && col ==0 ) {
                    	int temp = state[face][row][col+1];
                    	int temp1 = state[face][row+1][col+1];
                    	state[face][row][col+1] = state[face+2][row][col];
                    	state[face][row+1][col+1]=state[face+2][row+1][col];
                    	state[face+2][row+1][col]=temp;
                    	state[face+2][row][col] = temp1;
                    	 
                    }

                 
                    }

                    
                }

            }
		}
		if(move=="B`") {
			for (int face = 0; face < state.length; face++) {
                // Iterate through each row of the face
                for (int row = 0; row < state[face].length; row++) {
                    // Iterate through each column of the face
                    for (int col = 0; col < state[face][row].length; col++) {
                    if(face ==0 && row == 0 && col == 0) {	//face 0 
                    	int temp = state[face][row][col];
                    	int temp1 = state[face][row][col+1];
                    	state[face][row][col] = state[face+4][row+1][col];
                    	state[face][row][col+1]=state[face+4][row][col];
                    	state[face+4][row+1][col]=temp;
                    	state[face+4][row][col] = temp1;
                    	
                    }
                    if(face == 1 && row ==0 && col ==0 ) {
                    	int temp = state[face][row][col+1];
                    	int temp1 = state[face][row+1][col+1];
                    	state[face][row][col+1] = state[face+3][row+1][col];
                    	state[face][row+1][col+1]=state[face+3][row][col];
                    	state[face+3][row+1][col]=temp;
                    	state[face+3][row][col] = temp1;
                    	
                    	 
                    }
                    if(face == 3 && row ==0 && col ==0 ) {
                    	int temp = state[face][row+1][col];
                    	int temp1 = state[face][row+1][col+1];
                    	state[face][row+1][col] = state[face+1][row][col];
                    	state[face][row+1][col+1]=state[face+1][row+1][col];
                    	state[face+1][row][col]=temp;
                    	state[face+1][row+1][col] = temp1;
                    	 
                    }
                    if(face == 5 && row ==0 && col ==0 ) {
                    	int temp = state[face][row][col];
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

            }
		}
//        switch (move) {
//        	case "U":
//                for (int face = 0; face < state.length; face++) {
//                    // Iterate through each row of the face
//                    for (int row = 0; row < state[face].length; row++) {
//                        // Iterate through each column of the face
//                        for (int col = 0; col < state[face][row].length; col++) {
//                        if(face ==0 && row == 0 && col == 0) {	//face 0 
//                          int i = state[face][row][col];	
//                          state[face][row][col] = state[face][row][col+1];// 0 => 2
//                          state[face][row][col+1] = i ; 
//                          i = state[face][row+1][col];
//                          state[face][row+1][col] = state[face][row+1][col+1];
//                          state[face][row+1][col+1] = i ;
//                          i = state[face][row][col] ; 
//                          state[face][row][col] = state[face][row+1][col+1] ;
//                          state[face][row+1][col+1] = i ; 
//                         
//
//                        }
//                        if(face == 1 && row ==0 && col ==0 ) {
//                        	int[] pair = state[face][row];
//                        	state[face][row] =state[face+4][row] ;
//                        	state[face+4][row] = pair;
//                        	 
//                        }
//                        if(face == 2 && row ==0 && col ==0 ) {
//                        	int[] pair = state[face][row];
//                        	state[face][row] =state[face+2][row] ;
//                        	state[face+2][row] = pair;
//                        	 
//                        }
//                        if(face == 2 && row ==0 && col ==0 ) {
//                        	int[] pair = state[face][row];
//                        	state[face][row] =state[face+3][row] ;
//                        	state[face+3][row] = pair;
//                        }
//                     
//                        }
//    
//                        
//                    }
//
//                }
//        	case "U`":
//                for (int face = 0; face < state.length; face++) {
//                    // Iterate through each row of the face
//                    for (int row = 0; row < state[face].length; row++) {
//                        // Iterate through each column of the face
//                        for (int col = 0; col < state[face][row].length; col++) {
//                        if(face ==0 && row == 0 && col == 0) {	//face 0 
//                          int i = state[face][row][col];	
//                          state[face][row][col] = state[face][row][col+1];
//                          state[face][row][col+1] = i ; 
//                          i = state[face][row+1][col];
//                          state[face][row+1][col] = state[face][row+1][col+1];
//                          state[face][row+1][col+1] = i ;
//                          i = state[face][row][col+1] ; 
//                          state[face][row][col+1] = state[face][row+1][col] ;
//                          state[face][row+1][col] = i ; 
//                         
//
//                        }
//                        if(face == 1 && row ==0 && col ==0 ) {
//                        	int[] pair = state[face][row];
//                        	state[face][row] =state[face+4][row] ;
//                        	state[face+4][row] = pair;
//                        	
//                        	 
//                        }
//                        if(face == 2 && row ==0 && col ==0 ) {
//                        	int[] pair = state[face][row];
//                        	state[face][row] =state[face+2][row] ;
//                        	state[face+2][row] = pair;
//                        	 
//                        }
//                        if(face == 4 && row ==0 && col ==0 ) {
//                        	int[] pair = state[face][row];
//                        	state[face][row] =state[face-3][row] ;
//                        	state[face-3][row] = pair;
//                        }
//                     
//                        }
//    
//                        
//                    }
//
//                }
//        	case "F`":
//                for (int face = 0; face < state.length; face++) {
//                    // Iterate through each row of the face
//                    for (int row = 0; row < state[face].length; row++) {
//                        // Iterate through each column of the face
//                        for (int col = 0; col < state[face][row].length; col++) {
//                        if(face ==0 && row == 0 && col == 0) {	//face 0 
//                        	int temp = state[face][row+1][col];
//                        	int temp1 = state[face][row+1][col+1];
//                        	state[face][row+1][col] = state[face+1][row][col];
//                        	state[face][row+1][col+1]=state[face+1][row+1][col];
//                        	state[face+1][row][col]=temp;
//                        	state[face+1][row+1][col] = temp1;
//                        	
//                        }
//                        if(face == 1 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col];
//                        	int temp1 = state[face][row+1][col];
//                        	state[face][row][col] = state[face+3][row+1][col+1];
//                        	state[face][row+1][col]=state[face+3][row][col+1];
//                        	state[face+3][row+1][col+1]=temp;
//                        	state[face+3][row][col+1] = temp1;
//                        	
//                        	 
//                        }
//                        if(face == 2 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col];
//                        	state[face][row][col] = state[face][row][col+1];
//                        	state[face][row][col+1] = temp;
//                        	temp = state[face][row+1][col+1];
//                        	state[face][row+1][col+1]=state[face][row+1][col];
//                        	state[face][row+1][col]=temp;
//                        	temp = state[face][row][col+1];
//                        	state[face][row][col+1] = state[face][row+1][col];
//                        	state[face][row+1][col] = temp;
//
//                        }
//                        if(face == 3 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col];
//                        	int temp1 = state[face][row][col+1];
//                        	state[face][row][col] = state[face-2][row+1][col];
//                        	state[face][row][col+1]=state[face-2][row][col];
//                        	state[face-2][row+1][col]=temp;
//                        	state[face-2][row][col] = temp1;
//                        	 
//                        }
//
//                     
//                        }
//    
//                        
//                    }
//
//                }
//        	case "R`":
//                for (int face = 0; face < state.length; face++) {
//                    // Iterate through each row of the face
//                    for (int row = 0; row < state[face].length; row++) {
//                        // Iterate through each column of the face
//                        for (int col = 0; col < state[face][row].length; col++) {
//                        if(face ==0 && row == 0 && col == 0) {	//face 0 
//                        	int temp = state[face][row][col+1];
//                        	int temp1 = state[face][row+1][col+1];
//                        	state[face][row][col+1] = state[face+5][row+1][col];
//                        	state[face][row+1][col+1]=state[face+5][row][col];
//                        	state[face+5][row+1][col]=temp1;
//                        	state[face+5][row][col] = temp;
//                        	
//                        }
//                        if(face == 1 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col];
//                        	state[face][row][col] = state[face][row][col+1];
//                        	state[face][row][col+1] = temp;
//                        	temp = state[face][row+1][col+1];
//                        	state[face][row+1][col+1]=state[face][row+1][col];
//                        	state[face][row+1][col]=temp;
//                        	temp = state[face][row][col+1];
//                        	state[face][row][col+1] = state[face][row+1][col];
//                        	state[face][row+1][col] = temp;
//
//                        }
//                        if(face == 2 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col+1];
//                        	int temp1 = state[face][row+1][col+1];
//                        	state[face][row][col+1] = state[face+3][row][col];
//                        	state[face][row+1][col+1]=state[face+3][row+1][col];
//                        	state[face+3][row][col]=temp;
//                        	state[face+3][row+1][col] = temp1;
//                        	
//                        	 
//                        }
//
//                        if(face == 3 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col+1];
//                        	int temp1 = state[face][row+1][col+1];
//                        	state[face][row][col+1] = state[face+2][row][col];
//                        	state[face][row+1][col+1]=state[face+2][row+1][col];
//                        	state[face+2][row+1][col]=temp;
//                        	state[face+2][row][col] = temp1;
//                        	 
//                        }
//
//                     
//                        }
//    
//                        
//                    }
//
//                }
//        	case "B`":
//                for (int face = 0; face < state.length; face++) {
//                    // Iterate through each row of the face
//                    for (int row = 0; row < state[face].length; row++) {
//                        // Iterate through each column of the face
//                        for (int col = 0; col < state[face][row].length; col++) {
//                        if(face ==0 && row == 0 && col == 0) {	//face 0 
//                        	int temp = state[face][row][col];
//                        	int temp1 = state[face][row][col+1];
//                        	state[face][row][col] = state[face+4][row+1][col];
//                        	state[face][row][col+1]=state[face+4][row][col];
//                        	state[face+4][row+1][col]=temp;
//                        	state[face+4][row][col] = temp1;
//                        	
//                        }
//                        if(face == 1 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col+1];
//                        	int temp1 = state[face][row+1][col+1];
//                        	state[face][row][col+1] = state[face+3][row+1][col];
//                        	state[face][row+1][col+1]=state[face+3][row][col];
//                        	state[face+3][row+1][col]=temp;
//                        	state[face+3][row][col] = temp1;
//                        	
//                        	 
//                        }
//                        if(face == 3 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row+1][col];
//                        	int temp1 = state[face][row+1][col+1];
//                        	state[face][row+1][col] = state[face+1][row][col];
//                        	state[face][row+1][col+1]=state[face+1][row+1][col];
//                        	state[face+1][row][col]=temp;
//                        	state[face+1][row+1][col] = temp1;
//                        	 
//                        }
//                        if(face == 5 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col];
//                        	state[face][row][col] = state[face][row][col+1];
//                        	state[face][row][col+1] = temp;
//                        	temp = state[face][row+1][col+1];
//                        	state[face][row+1][col+1]=state[face][row+1][col];
//                        	state[face][row+1][col]=temp;
//                        	temp = state[face][row][col+1];
//                        	state[face][row][col+1] = state[face][row+1][col];
//                        	state[face][row+1][col] = temp;
//
//                        }
//
//
//
//                     
//                        }
//    
//                        
//                    }
//
//                }
//
//        	case "D`":
//                for (int face = 0; face < state.length; face++) {
//                    // Iterate through each row of the face
//                    for (int row = 0; row < state[face].length; row++) {
//                        // Iterate through each column of the face
//                        for (int col = 0; col < state[face][row].length; col++) {
//                        	if(face == 1 && row ==1 && col ==0 ) {
//                            	int[] pair = state[face][row];
//                            	state[face][row] =state[face+4][row] ;
//                            	state[face+4][row] = pair;
//                            	 
//                            }
//                            if(face == 2 && row ==1 && col ==0 ) {
//                            	int[] pair = state[face][row];
//                            	state[face][row] =state[face+3][row] ;
//                            	state[face+3][row] = pair;
//                            	 
//                            }
//                            if(face == 4 && row ==1 && col ==0 ) {
//                            	int[] pair = state[face][row];
//                            	state[face][row] =state[face+1][row] ;
//                            	state[face+1][row] = pair;
//                            }
//                        if(face == 3 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col];
//                        	state[face][row][col] = state[face][row][col+1];
//                        	state[face][row][col+1] = temp;
//                        	temp = state[face][row+1][col+1];
//                        	state[face][row+1][col+1]=state[face][row+1][col];
//                        	state[face][row+1][col]=temp;
//                        	temp = state[face][row][col+1];
//                        	state[face][row][col+1] = state[face][row+1][col];
//                        	state[face][row+1][col] = temp;
//
//                        }
//
//
//
//                     
//                        }
//    
//                        
//                    }
//
//                }
//        	case "L`":
//                for (int face = 0; face < state.length; face++) {
//                    // Iterate through each row of the face
//                    for (int row = 0; row < state[face].length; row++) {
//                        // Iterate through each column of the face
//                        for (int col = 0; col < state[face][row].length; col++) {
//                        if(face ==1)
//                        	break;
//                        if(face ==0 && row == 0 && col == 0) {	//face 0 
//                        	int temp = state[face][row][col];
//                        	int temp1 = state[face][row+1][col];
//                        	state[face][row][col] = state[face+2][row][col];
//                        	state[face][row+1][col]=state[face+2][row+1][col];
//                        	state[face+2][row][col]=temp;
//                        	state[face+2][row+1][col] = temp1;
//                        	
//                        }
//                        if(face == 2 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col];
//                        	int temp1 = state[face][row+1][col];
//                        	state[face][row][col] = state[face+1][row][col];
//                        	state[face][row+1][col]=state[face+1][row+1][col];
//                        	state[face+1][row][col]=temp;
//                        	state[face+1][row+1][col] = temp1;
//                        	
//                        	 
//                        }
//                        if(face == 3 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col];
//                        	int temp1 = state[face][row+1][col];
//                        	state[face][row][col] = state[face+2][row+1][col+1];
//                        	state[face][row+1][col]=state[face+2][row][col+1];
//                        	state[face+2][row+1][col+1]=temp;
//                        	state[face+2][row][col+1] = temp1;
//                        	 
//                        }
//                        if(face == 4 && row ==0 && col ==0 ) {
//                        	int temp = state[face][row][col];
//                        	state[face][row][col] = state[face][row][col+1];
//                        	state[face][row][col+1] = temp;
//                        	temp = state[face][row+1][col+1];
//                        	state[face][row+1][col+1]=state[face][row+1][col];
//                        	state[face][row+1][col]=temp;
//                        	temp = state[face][row][col+1];
//                        	state[face][row][col+1] = state[face][row+1][col];
//                        	state[face][row+1][col] = temp;
//
//                        }
//
//
//
//                     
//                        }
//    
//                        
//                    }
//
//                }
//        		
//        }	
=======
                }break;
        	case "D":
                for (int face = 0; face < state.length; face++) {
                    // Iterate through each row of the face
                    for (int row = 0; row < state[face].length; row++) {
                        // Iterate through each column of the face
                        for (int col = 0; col < state[face][row].length; col++) {
                        if(face == 1 && row ==1 && col ==0 ) {
                        	int[] pair = state[face][row];
                        	state[face][row] =state[face+4][row] ;
                        	state[face+4][row] = pair;
                        	 
                        }
                        if(face == 2 && row ==1 && col ==0 ) {
                        	int[] pair = state[face][row];
                        	state[face][row] =state[face+2][row] ;
                        	state[face+2][row] = pair;
                        	 
                        }
                        if(face == 4 && row ==1 && col ==0 ) {
                        	int[] pair = state[face][row];
                        	state[face][row] =state[face-3][row] ;
                        	state[face-3][row] = pair;
                        }
                        if(face ==3 && row == 0 && col == 0) {	//face 0 
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
                            	   int i = state[face][row][col+1];
                            	   state[face][row][col+1] = state[face+2][row][col+1];
                            	   state[face+2][row][col+1] = i;
                            	    i = state[face][row+1][col+1];
                            	   state[face][row+1][col+1] =   state[face+2][row+1][col+1];
                            	   state[face+2][row+1][col+1] = i;
                               }
                               if(face ==1 && row ==0 && col == 0 ) {
                            	   int i = state[face][row][col];
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
                            	   int i = state[face][row][col+1];
                            	   state[face][row][col+1] = state[face+1][row][col+1];
                            	   state[face+1][row][col+1] = i;
                            	   i = state[face][row+1][col+1];
                            	   state[face][row+1][col+1] = state[face+1][row+1][col+1];
                            	   state[face+1][row+1][col+1] = i;
                               }
                               if(face ==3 && row ==0 && col == 0) {
                            	   int i = state[face][row][col+1];
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
                             	   int i = state[face][row][col];
                             	   state[face][row][col] = state[face+2][row][col];
                             	   state[face+2][row][col] = i;
                             	    i = state[face][row+1][col];
                             	   state[face][row+1][col] =   state[face+2][row+1][col];
                             	   state[face+2][row+1][col] = i;
                                }
                        	    if(face ==0 && row == 0 && col == 0) {
                              	   int i = state[face][row][col];
                              	   state[face][row][col] = state[face+3][row][col];
                              	   state[face+3][row][col] = i;
                              	    i = state[face][row+1][col];
                              	   state[face][row+1][col] =   state[face+3][row+1][col];
                              	   state[face+3][row+1][col] = i;
                              	   
                                 }
                        	    if(face ==0 && row == 0 && col == 0) {
                               	   int i = state[face][row][col];
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
                             	   int i = state[face][row][col];
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
                         	   int i = state[face][row+1][col];
                         	   state[face][row+1][col] = state[face+1][row][col];
                         	   state[face+1][row][col] = i;
                         	    i = state[face][row+1][col+1];
                         	   state[face][row+1][col+1] =   state[face+1][row+1][col];
                         	   state[face+1][row+1][col] = i;
                         	   
                            }
                            if(face ==3 && row == 0 && col == 0) {
                          	   int i = state[face][row][col];
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
                            	int i = state[face-3][row][col];
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
                        	  int i = state[face][row][col+1];
                        	  state[face][row][col+1] = state[face+4][row][col];
                        	  state[face+4][row][col] = i;
                        	  i = state[face][row][col];
                        	  state[face][row][col] = state[face+4][row+1][col];
                        	  state[face+4][row+1][col] = i ; 
                          }
                          if(face == 1 && row == 0 && col == 0) {
                        	  int i = state[face][row][col+1];
                        	  state[face][row][col+1] = state[face+2][row+1][col+1];
                        	  state[face+2][row+1][col+1] = i ;
                        	  i = state[face][row+1][col+1];
                        	  state[face][row+1][col+1] = state[face+2][row+1][col];
                        	  state[face+2][row+1][col] = i ;
                          }
                          if(face == 3 && row ==0 && col == 0 ) {
                        	  int i = state[face][row+1][col+1];
                        	  state[face][row+1][col+1] = state[face-3][row][col];
                        	  state[face-3][row][col] = i ;
                        	   i = state[face][row+1][col];
                        	  state[face][row+1][col] = state[face-3][row][col+1];
                        	  state[face-3][row][col+1] = i ;
     	
                          }
                        }
    
                        
                    }

                }break;
                  
                  
            
        		
              
        		
        }	
>>>>>>> Stashed changes
        return state;
    }
}


