package ga;

import java.util.ArrayList;

public class Permutations {
    private int cost=999999;
    private ArrayList<City> best;



    public void permutations(ArrayList<City> list){
       permutations(null, list, null);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ArrayList<City> getBest() {
        return best;
    }

    public void setBest(ArrayList<City> best) {
        this.best = best;
    }

    public  ArrayList<City> permutations(ArrayList<City> prefix, ArrayList<City> suffix, ArrayList<ArrayList<City>> output){
       if(prefix == null)
          prefix = new ArrayList<City>();
       if(output == null)
          output = new ArrayList<ArrayList<City>>();
       if(suffix.size() == 1){
          ArrayList<City> newElement = new ArrayList<City>(prefix);
          newElement.addAll(suffix);
          int costNow=cost(newElement);
          if(costNow<this.cost){
              best=newElement;
              this.cost=costNow;
          }
          return best;
       }
       for(int i = 0; i < suffix.size(); i++){
          ArrayList<City> newPrefix = new ArrayList<City>(prefix);
          newPrefix.add(suffix.get(i));
          ArrayList<City> newSuffix = new ArrayList<City>(suffix);
          newSuffix.remove(i);
          permutations(newPrefix,newSuffix,output);
       }



       return best;
    }

    public  int cost(ArrayList<City> path){
       int cost=0;
        int i=0;
        while(i<path.size()-1){
           cost+=path.get(i).distance(path.get(i+1).getX(),path.get(i+1).getY());
            i++;
        }
        cost+=path.get(path.size()-1).distance(path.get(0).getX(), path.get(0).getY());
        return cost;
    }

}