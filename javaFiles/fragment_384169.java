public class Human implements Visited {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitHuman(this);
    }

}