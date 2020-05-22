OpenSimplexNoise n1 = new OpenSimplexNoise(seed1);
OpenSimplexNoise n2 = new OpenSimplexNoise(seed2);
OpenSimplexNoise n3 = new OpenSimplexNoise(seed3);

for each x,y {
    double value = (n1.eval(x / 48.0, y / 48.0, 0.5) + n2.eval(x / 24.0, y / 24.0, 0.5) * .5 + n3.eval(x / 12.0, y / 12.0, 0.5) * .25) / (1 + .5 + .25);
    //Do whatever you need to with that value
}