package ga;

import java.util.Random;

public class Path implements Comparable {
    private City [] path;
    private int numCities;
    private int cost;
    private int fitness;

    public Path(int numCities) {
        this.numCities = numCities;
        CreatePath();
        cost =0;
        calculateCost();
        fitness =0;

    }
    public void calculateCost(){
        cost=0;
        int i=0;
        while(i<numCities-1){
           cost+=path[i].distance(path[i+1].getX(),path[i+1].getY());
            i++;
        }
        cost+=path[path.length-1].distance(path[0].getX(), path[0].getY());
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
    public int getCost() {
        return cost;
    }

    public void setCost(int distance) {
        this.cost = distance;
    }
    /* Overload compareTo method */
    public int compareTo(Object obj){
     Path tmp = (Path) obj;
     if(this.cost < tmp.cost){
         return 1;
     }
     else if(this.cost > tmp.cost){
         return -1;
     }
     else{
         return 0;
     }
    }
     public void CreatePath(){
        path= new City[numCities];
        for (int i = 0; i < path.length; i++) {
            path[i]=new City(i,RandomNum(1, 99),RandomNum(1, 99));            
        }
    }

    public int RandomNum(int min, int max){
        return min+ (new Random()).nextInt(max-min);        
    }

    public City[] getPath() {
        return path;
    }

    public void setPath(City[] path) {
        this.path = path;
        calculateCost();
    }

    public int getNumCities() {
        return numCities;
    }

    public void setNumCities(int numCities) {
        this.numCities = numCities;
    }

}