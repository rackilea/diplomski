OpenSimplexNoise n1 = new OpenSimplexNoise(seed1);
OpenSimplexNoise n2 = new OpenSimplexNoise(seed2);
OpenSimplexNoise n3 = new OpenSimplexNoise(seed3);

for each x,y {
    double elevation = n1.eval(x / 24.0, y / 24.0, 0.5);
    double temperature = n2.eval(x / 24.0, y / 24.0, 0.5);
    double precipitation = n3.eval(x / 24.0, y / 24.0, 0.5);

    if (elevation < 0)
        water
    else {
        //decide biome based on temperature, precipitation, and elevation
    }
}