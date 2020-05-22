//Grab the time when you start
long startTime = System.currentTimeMillis();

//Play game

//When you finish grab the current time and work out the time taken
long totalTime = System.currentTimeMillis() - startTime;    
//Convert into minutes and seconds
int seconds = (int) ((totalTime / 1000) % 60);
int minutes = (int) ((totalTime / 1000) / 60);
//Show time
System.out.println("Time taken: "+minutes+"m, "+seconds+"s");