final long NANOSEC_PER_SEC = 1000l*1000*1000;

long startTime = System.nanoTime();
while ((System.nanoTime()-startTime)< 5*60*NANOSEC_PER_SEC){
  // do stuff
}