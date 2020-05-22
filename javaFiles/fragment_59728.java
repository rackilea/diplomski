void draw() {

    // "fade" the entire view 
    blendMode(DIFFERENCE);
    fill(1, 1, 1, 255);
    rect(0, 0, width, height);

    blendMode(ADD);

    // draw shape
    // [...]

}