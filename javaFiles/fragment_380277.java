class Bullet
{
    float x, y, v, ang;
    Bullet(float x, float y, float v, float ang)
    {
        this.x = x;
        this.y = y;
        this.v = v;
        this.ang = ang;
    }

    void update() {
        x += v * cos(ang);
        y += v * sin(ang);
    }

    void draw()
    {
        pushMatrix();

        // transalte rectangle to new position
        translate(x, y);

        // rotate rectangle in direction of move
        rotate(ang);

        // draw rectangle around center
        rect(0, 0, 10, 10);

        popMatrix();
    }
}