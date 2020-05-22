public String toString(String line) {
   for(int i = 0; i < position; i++){
      line = info[i]; 
      position++;
   }
   return info[2]+", "+info[0]+", "+info[1]+", "+info[3];
}