public abstract class SandwichDecorator implements Sandwitch {

    protected final Sandwitch current;

    public SandwichDecorator(Sandwitch current) {
        this.current = current;
    }

}