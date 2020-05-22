import java.util.Arrays;


public class ConcreteField implements Field<Field>{

    private String name;

    @Override
    public int compareTo(Field other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ConcreteField[] c = new ConcreteField[3];
        c[0] = new ConcreteField();
        c[1] = new ConcreteField();
        c[2] = new ConcreteField();
        c[0].setName("c");
        c[1].setName("b");
        c[2].setName("a");

        Arrays.sort(c);
        for(int i=0;i<c.length;i++) {
            System.out.println(c[i].getName());
        }

    }
}