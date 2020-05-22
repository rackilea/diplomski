package example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeadlockDetection {
    static String [][] grid = {{"w","n","x","x","x","n","n"},
        {"x","w","n","n","n","x","n"},
        {"n","x","w","n","n","n","n"},
        {"n","n","n","n","n","n","x"},
        {"n","n","n","n","n","n","n"},
        {"n","n","w","n","n","n","w"},
        {"w","w","w","w","w","w","w"}};

    public static void main(String[] args) {
        System.out.println(isDeadlock());
    }


    public static class Node{
        int id;
        List<Node> acquirerNodes = new ArrayList<Node>();
        public Node(int id){
            this.id=id;
        }
    }

    public static boolean isDeadlock(){
        List<Node> nodes = new ArrayList<Node>();
        //Construct Graph
        for(int i=0; i< grid.length; i++){
            nodes.add(new Node(i));
        }
        for(int i=0; i<grid.length; i++){
            List<Node> waitingNodes = new ArrayList<Node>();
            Node acquirer = null;
            for(int j=0; j<grid.length; j++){
                if(grid[j][i].equals("w") ){
                    waitingNodes.add(nodes.get(i));
                } else if(grid[j][i].equals("x") ){
                    acquirer = nodes.get(i);
                }
                if(acquirer != null)
                    for(Node n: waitingNodes)
                        n.acquirerNodes.add(acquirer);
            }
        }
        //In case of non-strongly disconnected graph, we may need to traverse through all nodes.
        HashSet<Node> nodesFoundInGraph = new HashSet<Node>();
        for(int i=0; i< grid.length; i++){
            if(!nodesFoundInGraph.contains(nodes.get(i))){
                HashSet<Node> visited = new HashSet<Node>();
                if(isCycle(nodes.get(i), visited))
                    return true;
                nodesFoundInGraph.addAll(visited);
            }
        }
        return false;
    }

    public static boolean isCycle(Node node, Set<Node> visited){
        if(visited.contains(node)){
            return true;
        }
        visited.add(node);
        for(Node n: node.acquirerNodes){
            if(isCycle(n, visited)){
                return true;
            }
        }
        return false;
    }
}