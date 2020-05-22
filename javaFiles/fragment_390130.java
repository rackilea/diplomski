int iterations=100000;
long time = System.nanoTime();
for(int i = 3; i < 100000; i += 2) { //notice: always use curly brackets!!!
    isPrime(i);
}
long endTime = System.nanoTime();
System.out.println("Time to go through " + iterations + " iterations: " + (endTime>time?endTime-time:endTime+time));
//notice: nanoTime might turn around, resulting in smaller (negative) endTime value