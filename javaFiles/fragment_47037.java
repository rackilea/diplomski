class ShapeBuilder {
    ...
    public Shape build() {
    ....
}

class CircleBuilder extends ShapeBuilder{
    ...
    @Override
    public bridge Shape build() { // override matches full JVM signature
        return <Circle>build(); // call other method with different return type
    }
    public Circle build() {
    ....
}