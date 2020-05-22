String item;
int[] coords = new int[2];

boolean finished = false;
while(!finished){ // if we don't find what you searched, then keep checking
   item = JOptionPane.showInputDialog("What would you like to search for?");
   for(int i = 0; i < HomeDepot.length; i++) { 
       for(int j = 0; j < HomeDepot[i].length; j++) {
           if(HomeDepot[i][j].equals(item)) {
               coords[0] = i;
               coords[1] = j;
               finished = true;
           }
           if(finished) break; 
       } 
       if(finished) break;
   }
   if(!finished)
      System.out.println("Could not find " + item + "! Please try again.");
}
System.out.println(coords[0] + "," + coords[1]); // prints the location once you've
                                                 // searched a valid String in the matrix