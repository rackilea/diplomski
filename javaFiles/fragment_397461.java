public Random getPseudorandomNumberGenerator(){
    return new Random(seedRng.nextLong());
}

public Random getPseudorandomNumberGeneratorTest(long testSeed){
    return new Random(testSeed); 
}