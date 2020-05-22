@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class A {

    public String getType() {
        return "A";
    }
}

@Entity
class B extends A {

    @Override
    public String getType() {
        return "B";
    }
}