for(int i = 0; i < outArray.length; i++) {
   for(int j = 0; j < outArray[0].length; j++){
    outArray[i][j] = (char)br.read();
   }
   br.read(); // read the next character (which will be a newline) and ignore it
}