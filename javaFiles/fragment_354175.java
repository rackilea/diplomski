class X {
    String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class Y {
    String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

public class Test1 {

    public static void main(String[] args) throws Exception {
        X x = new X();
        x.setName("test");
        Y y = new Y();
        BeanUtils.copyProperties(x, y);
        System.out.println(y.getName());
    }
}