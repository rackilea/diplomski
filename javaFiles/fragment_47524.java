int cord_x = 6, cord_y = 5, num = 10;
     ArrayList<Integer>[][] mundo = (ArrayList<Integer>[][])
                                             new ArrayList<?>[cord_x][cord_y];
     for(int i = 0; i < cord_x; i++){
         for(int j = 0; j < cord_y; j++){

             //***Instantiate the ArrayList---This is required***
             mundo[i][j] = new ArrayList<Integer>(); 
             for(int k = 0; k < num; k++){
                 // Add the elements in the array list
                 mundo[i][j].add(new Integer(i+j+k)); 
             }
         }
     }

     //Check the elements
     for(int i = 0; i < cord_x; i++){
         for(int j = 0; j < cord_y; j++){
             for(int k = 0; k < num; k++){
                 // prints the elements
                 System.out.println("mundo["+i+"]["+j+"]- place "
                      +k+" Element == " +mundo[i][j].get(k)); 
             }
         }
     }