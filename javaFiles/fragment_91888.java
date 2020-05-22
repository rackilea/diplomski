public class Integer implements Addable<Integer> {
    public Integer plus(Integer that) {
       return new Integer(this.value + that.value);
    }

     // private implementation details omitted
}