class Zombie{

    int randR;
    int randG;
    int randB;

    double randomXSpawn;
    double randomYSpawn;

    public Zombie(double randomXSpawn, double randomYSpawn) {
        super();
        this.randomXSpawn = randomXSpawn;
        this.randomYSpawn = randomYSpawn;

        randR = (int)Math.random() * 255;
        randG = (int)Math.random() * 255;
        randB = (int)Math.random() * 255;
    }   
}