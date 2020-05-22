class Mover {

    // [...]

    void bounce() {

        // [...]

        if ((loc.y > height) || (loc.y < 0)) {
            vel.y *= -1;
            acc.y *= -1;
            loc.y = loc.y > height ? height : 0; // limit y in the range [0, height]
        }
    }
}