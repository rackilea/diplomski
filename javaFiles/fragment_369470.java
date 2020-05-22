class UIArc{

    // [...]

    void setArc(float a, float b, float c, float d, float start, float stop){
        this.a = min(a, c);
        this.b = min(b, d);
        this.c = max(a, c);
        this.d = max(b, d);
        this.start = start;
        this.stop = stop;
    }

    void draw() {
        arc(this.a, this.b, this.c, this.c,
        radians(this.start), radians(this.stop));
    }
}