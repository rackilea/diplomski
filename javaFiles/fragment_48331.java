public class Sheep {

    // data for intrinsic state of sheep omitted..

    private final Circle view ;

    public Sheep() {
        this.view = new Circle(...);
        // configure view...
    }

    public Node getView() {
        return view ;
    }

    // logic etc... manipulates intrinsic state of sheep....
}