void setup() {
    size(500,500);
}

void draw() {

    background(0, 0, 0);

    stroke(255);
    fill(255, 0, 0);

    PVector l1p1 = new PVector(250, 150);
    PVector l1p2 = new PVector(300, 300);
    PVector l2p1 = new PVector(200, 180);
    PVector l2p2 = new PVector(300, 220);
    PVector l3p1 = new PVector(200, 300);
    PVector l3p2 = new PVector(250, 280);

    line(l1p1.x, l1p1.y, l1p2.x, l1p2.y);
    line(l2p1.x, l2p1.y, l2p2.x, l2p2.y);
    line(l3p1.x, l3p1.y, l3p2.x, l3p2.y);

    PVector dir1 = PVector.sub(l1p2, l1p1);
    PVector dir2 = PVector.sub(l2p2, l2p1);
    PVector dir3 = PVector.sub(l3p2, l3p1);

    PVector x1 = Intersect(l1p1, dir1, l2p1, dir2);
    circle(x1.x, x1.y, 10);
    PVector x2 = Intersect(l1p1, dir1, l3p1, dir3);
    circle(x2.x, x2.y, 10);
    PVector x3 = Intersect(l2p1, dir2, l3p1, dir3);
    circle(x3.x, x3.y, 10);
}