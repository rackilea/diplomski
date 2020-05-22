// read all lines
 while (readAndStore.hasNextLine()) {

     String line = readAndStore.readLine ();


     // split using =
     String [] words = line.split ("=");     // assuming you are going to parse all lines

     if (words[0].equals ("ENERGY")) {
         energy = Double.parseDouble (words[1]);
     }