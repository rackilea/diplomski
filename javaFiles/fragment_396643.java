while(letters.length() <= 3){
    String line = rd.readLine();
    // Finds the words that follow the game rules
    if(line.indexOf(one) != -1 && line.indexOf(two) > line.indexOf(one)  && line.indexOf(three) > line.indexOf(two)){
         println(line);
    }       
}