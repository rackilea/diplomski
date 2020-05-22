public class Japan {

public static void main(String[]args) {
    ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> nodeList = new ArrayList<Integer>();
    for(int i =0;i<5;i++) {
        for(int j=0;j<4;j++) {
            nodeList.add(i);
            nodeList.add(j);
            nodes.add(new ArrayList<>(nodeList)); // This copies nodeList, and adds the copy to nodes
            nodeList.remove(1);
            nodeList.remove(0);
         }
    }
    System.out.println(nodes);
}}