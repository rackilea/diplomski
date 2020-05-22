import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {

        List<MyVector> vectorList = new ArrayList<MyVector>();
        vectorList.add(new MyVector("A", "B"));
        vectorList.add(new MyVector("B", "C"));
        vectorList.add(new MyVector("C", "D"));
        vectorList.add(new MyVector("D", "A"));
        vectorList.add(new MyVector("A", "C"));

        List<String> pointsHistory=new ArrayList<String>();
        //to record points that have been visited
        //record the path 
        String path = "";
        //method call
        pathFinder(new MyVector(null, "A"), pointsHistory, vectorList, path);
    }

    //Recursive method. moves one node forward until there is no more nodes OR the next node is the same as a previously taken node

    public static void pathFinder(MyVector prevVector, List<String>  pointsHistory, List<MyVector> vectorList, String path) {
        pointsHistory.add(prevVector.child);
        //add the current node to the path
        path = path + prevVector.child;
        // search if there is a next node.  looped to search all possible paths -> no need to do magic with equals
        for(MyVector vector:vectorList)
            if(vector.parent.equals(prevVector.child)) {
                  System.out.println("Next vector: " + vector.parent + vector.child);
                  if (pointsHistory.contains(vector.child)) {
                    System.out.println("Result " + path);  //You get the end result here -> if we have reached a loop
                } else {
                    pointsHistory.add(vector.child);
                     pathFinder(vector, new ArrayList<>(pointsHistory), vectorList, path);
                }
            }          
    }

    /*object vector */  
    public static class MyVector {
        String parent, child;

        public MyVector(String parent, String child) {
            this.parent = parent;
            this.child = child;
        }
    }
}