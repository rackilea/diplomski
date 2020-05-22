public int sum(Planet[] planets) {
    int sum = 0;
    for(Planet planet : planets){
        sum += planet.moons; 
    }
    return sum;
}