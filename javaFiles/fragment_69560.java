while ( factFile.hasNextLine() && numberOfLines < NUM_ROW){
                 fact = input.nextLine();
                 StringTokenizer st2 = new StringTokenizer(fact, ",")    ;
                 //facts.add(fact);
                while (st2.hasMoreElements()){
                  for ( int j = 0; j < NUM_COL ; j++) {
                    foodArray [numberOfLines][j]= st2.nextToken(); 
                    System.out.println(foodArray[numberOfLines][i]);
                 }
                }  
                 numberOfLines++;
            }