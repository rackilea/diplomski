for (y = 0; y < words[x].length() - 1; y++){
   if (words[x].charAt(y) == grid[rij + y][kolom].charAt(0)){
   array[2] = 1;
   }
   if (words[x].charAt(y) == (grid[rij][kolom + y].charAt(0))){
   array[2] = 2;
   }
   if (words[x].charAt(y) == (grid[rij + y][kolom + y].charAt(0))){
   array[2] = 3;
   }

}
y=0;