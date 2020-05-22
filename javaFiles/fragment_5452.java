public void initializeAndExecute(int runAmount) {
   tiles = new Tile[50]; //array size, 50!!!

   for (int k = 0; k < runAmount; k++) { //amount of generating new array
       for (int i = 0; i < 50; i++) { //put 50 objects in array
           tiles[i] = new Tile(); //constructor creates random coordinates
       }
       ...
   }
}