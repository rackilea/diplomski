public class Dog implements Stateful<Dog> {
    private int age;
    private int type;
    private String name;

    public Dog() {
        this(0, 0, "");
    }

    public Dog(int age, int type, String name) {
        super();
        this.age = age;
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog [age=" + age + ", type=" + type + ", name=" + name + "]";
    }

    @Override
    public Dog load(String data) {
        String[] fragments = StatefulUtil.parse(data);

        this.age = Integer.parseInt(fragments[1], 10);
        this.type = Integer.parseInt(fragments[2], 10);
        this.name = StatefulUtil.decode(fragments[3]);

        return this;
    }

    @Override
    public String save() {
        StringBuffer buff = new StringBuffer(Stateful.DATA_SEP);

        buff.append(StatefulUtil.format(this.age)).append(Stateful.DATA_SEP);
        buff.append(StatefulUtil.format(this.type)).append(Stateful.DATA_SEP);
        buff.append(StatefulUtil.encode(this.name)).append(Stateful.DATA_SEP);

        return buff.toString();
    }
}