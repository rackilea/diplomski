private static class Node implements Comparable<Node>{
    public int compareTo(Node n) {
        if(this.weight < n.weight){
            return -1;
        }else if(this.weight > n.weight){
            return 1;
        }else
            return 0;
    }
}