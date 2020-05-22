public class Person {
    private Man father;
    private Woman mother;

    public Person(Man father, Woman mother) {
        this.father = father;
        this.mother = mother;
    }
}

public class Man extends Person {
    public Man(Man father, Woman mother) {
        super(father, mother);
    }
}

public class Woman extends Person {
    public Woman(Man father, Woman mother) {
        super(father, mother);
    }
}