class Ball {

    // [...]

    void display() {
        pushMatrix();
        translate(pos.x, pos.y, -pos.z);
        sphere(size);
        noFill();
        popMatrix();
    }
}