ArrayList<Integer> init;
public Solution(ArrayList<Integer> data) {
    this.data = data;
    this.init = new ArrayList<Integer>(data);
}    

public ArrayList<Integer> restore() {
    ArrayList<Integer> cpy = new ArrayList<Integer>(this.init);
    return cpy;
}