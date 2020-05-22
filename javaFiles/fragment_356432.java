public class InputManipulation {

    Integer total;

    public InputManipulation() {
        this.total = 0;
    }

    public void add(Integer num) {
        this.total += num;
        System.out.println(this.total);
    }

    public void add(String str) {
        System.out.println(str);
    }

}