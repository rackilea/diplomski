public Human {
    public static ArrayList<Human> humans = new ArrayList<Human>();

    private String name;
    private int old;

    public Human(String name, int old) {
        this.name = name;
        this.old = old;
        humans.add(this);
    }

    public static void main(String args[])
    {
        Human john = new Human("John", 21);
        Human michael = new Human("Michael", 31);
        Human levi = new Human("Levi", 41);

        System.out.println(Human.humans.size());
    }
}