public class Node{
    //Fields used by the A* call - no problem here
    private boolean obstacle;

    //Fields *edited* by the A* call
    private HashMap<String,Float> distanceFromStart;
    private HashMap<String,Node> previous;
    private HashMap<String,Integer> heuristic;

    //other fields and stuff

    public boolean isObstacle(){
        return obstacle;
    }

    public float getDistanceFromStart(String id){
        return distanceFromStart.get(id);
    }

    public void setDistanceFromStart(String id, float f){
        distanceFromStart.put(id, f);
    }

    public Node getPrevious(String id){
        return previous.get(id);
    }

    public void setPrevious(String id, Node p){
        previous.put(id,p);
    }

    public int getHeuristic(String id){
        return heuristic.get(id);
    }

    public void setHeuristic(String id,int h){
        heuristic.put(id,h);
    }
}