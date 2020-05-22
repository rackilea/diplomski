class Mover {

    // [...]

    void edges() {
        if (loc.x > width) {
            loc.x = width;
        } else if (loc.x < 0) {
            loc.x = 0;
        }
        if (loc.y > height) {
            loc.y = height;
        } else if (loc.y < 0) {
            loc.y = 0;
        }
    }