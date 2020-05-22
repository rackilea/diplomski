public class Node{
    //Fields used by the A* call - no problem here
    private boolean obstacle;

    //Fields *edited* by the A* call
    private float distanceFromStart;
    private Node previous;
    private int heuristic;

    //other fields and stuff

    public boolean isObstacle(){
        return obstacle;
    }

    public float getDistanceFromStart(){
        return distanceFromStart;
    }

    public void setDistanceFromStart(float f){
        distanceFromStart = f;
    }

    public Node getPrevious(){
        return previous;
    }

    public void setPrevious(Node p){
        previous = p;
    }

    public int getHeuristic(){
        return heuristic;
    }

    public void setHeuristic(int h){
        heuristic = h;
    }
}