void draw() {
    background(255);

    b.wind(0.5);
    b.gravity();
    b.update();
    b.bounce();
    b.edges();

    b.display();
}