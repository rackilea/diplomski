interface Action {
    void run(Scanner args);
}

class Drink implements Action {
    @Override
    public void run(Scanner args) {
        if (!args.hasNext())
            throw new IllegalArgumentException("What should I drink?");
        System.out.println("Drinking " + args.next());
    }
}

class Look implements Action {
    @Override
    public void run(Scanner args) {
        if (!args.hasNext())
            throw new IllegalArgumentException("Where should I look?");
        System.out.println("Looking " + args.next());
    }
}