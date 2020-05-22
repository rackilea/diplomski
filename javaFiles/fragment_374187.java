long n = 0; 

double randomWeight = 0.5;

while(true) {

    nextVal = range.getRandomValue(); 

    double temp = AMPLITUDE*(randomWeight*((double)nextVal)+(1.0-randomWeight)*Math.sin(2.0*Math.PI*((double)n)*WIDTH_FACTOR));


    nextVal = (long)temp; 

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