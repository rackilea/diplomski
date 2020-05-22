public static void main(String[] args) {

    Figure[] figures = new Figure[3];
    figures[0] = new Circle();
    figures[1] = new Circle();
    figures[2] = new Square();

    for (Figure figure : figures) {
        figure.getColor();
        figure.draw();
        if (figure.getType() == FigureType.Circle) {
            ((Circle) figure).getRadius();
        }
    }
}