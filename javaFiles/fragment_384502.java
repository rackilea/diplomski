PVector p = new PVector(200, 200);
PVector a = new PVector(50, 50);
PVector b = new PVector(350, 50);
PVector n = new PVector(350, 50); // |p2 - p1|

void setup() {
    size(400, 400); 
    strokeWeight(2);
    strokeWeight(1);

    // initialize our normalized (unit length) line direction
    n.sub(a);
    n.normalize();
}

void draw() {
    drawCircle();
}

PVector getNearestPointOnLine(PVector p, PVector a, PVector n){
    // the notation turns the computation inside out,
    // but this is equivalent to the above equation
    PVector q = PVector.mult(n, -PVector.sub(a, p).dot(n));
    q.add(a);
    return q;
}

void drawCircle() {
    // lets draw everything here where we can see it
    background(255, 255, 255);
    line(a.x, a.y, b.x, b.y);

    fill(50, 120, 120);
    //circle

    // NOTE: this may require hooking up a mouse move event handler
    p.x = mouseX;
    p.y = mouseY;
    PVector q = getNearestPointOnLine(p, a, n);

    ellipse(q.x, q.y, 75, 75); 
    //circle center
    ellipse(q.x, q.y, 7, 7);  
    fill(0); // make text visible on white background
    text("Q", q.x + 15, q.y + 5);
    //fill(50, 120, 120);
}