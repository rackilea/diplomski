interface Shape {
    accept(ShapeProcessor processor);
}

class Circle implements Shape {
    accept(ShapeProcessor processor) {
        processor.visit(this);
    }
}

class Squere implements Shape {
    accept(ShapeProcessor processor) {
        processor.visit(this);
    }
}

interface ShapeProcessor {
    visit(Circle circle);
    visit(Squere squere);
}