long n = 0; 

while(true) {

    nextVal = range.getRandomValue(); 
    if(n % SPIKE_PERIOD == 0) nextVal = SPIKE_APLITUDE*nextVal;

    n++;


    System.out.println(nextVal);

    StdDraw.point(prevVal, nextVal);
    StdDraw.line(t-1, prevVal, t, nextVal);

    StdDraw.show(100);

    prevVal = nextVal; 
    t = (t+1) % 100;
    if(t == 0){
        StdDraw.clear(); 

}