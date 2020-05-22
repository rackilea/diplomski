public class Cheese implements Comparable<Cheese> {

    String num;

    public Cheese(String num){
        this.num = num;
    }

    public String getString(){
        return num;
    }

    public int compareTo(Cheese that) {
        return this.num.compareTo(that.num);
    }
}