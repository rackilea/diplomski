MethTmr1 = System.nanoTime();
if (Snw.Count()) {
    //expensive! Added to outer time
    //MethTmr = System.nanoTime();
    Snw.Snow_AI();
     //expensive! Added to outer time
    //MethTPS = 1000000000 / (System.nanoTime() - MethTmr);
}
try{
    MethTPS1 = 1000000000 / (System.nanoTime() - MethTmr1);
}catch(Exception e){}