public class Japan {

public static void main(String[]args) {
    ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
    for(int i =0;i<5;i++) {
        for(int j=0;j<4;j++) {
            ArrayList<Integer> nodeList = new ArrayList<Integer>(); // this creates a new list each time it is executed
            nodeList.add(i);
            nodeList.add(j);
            nodes.add(nodeList);
         }
    }
    System.out.println(nodes);
}}