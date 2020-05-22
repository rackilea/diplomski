/**
* return random number with seed based on coordinates.
*/
double locationValue(int x,int y){
    long seed = z;
    seed = x + (seed << 32); // make x and z semi-independent parts of the seed.
    Random r = new Random(seed);
    return r.nextDouble();
}