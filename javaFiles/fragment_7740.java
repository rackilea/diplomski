Random generator;

public RandomWalk(int gridSize){
    generator = new Random();
    gridSize = generator.nextInt();
    this.gridSize = gridSize;
}



public RandomWalk(int gridSize, long seed){
    generator = new Random(seed);
    gridSize = generator.nextInt();
    this.gridSize = gridSize;
}