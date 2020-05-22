public static class EdgeTuple  implements Comparable<EdgeTuple> {
    int label1;
    int label2;
    public EdgeTuple(int label1, int label2){
        int min = Math.min(label1, label2);
        int max = Math.max(label1, label2);
        this.label1 = min;
        this.label2 = max;
    }


    @Override
    public int compareTo(EdgeTuple o) {
        return this.label1 - o.label1;
    }
}