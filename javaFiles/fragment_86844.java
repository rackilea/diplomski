class Line implements Cloneable {

    private Point start;
    private Point end;

    public Line() {
        //Careful: This will not happen for the cloned object
        SomeGlobalRegistry.register(this);
    }

    @Override
    public Line clone() {
        //calling super.clone is going to create a shallow copy.
        //If we want a deep copy, we must clone or instantiate
        //the fields ourselves
        Line line = (Line)super.clone();
        //assuming Point is cloneable. Otherwise we will
        //have to instantiate and populate it's fields manually
        line.start = this.start.clone();
        line.end = this.end.clone;
        return line;
    }
}