void draw() 
{
    update();

    background(200,200,200);
    rectMode(CENTER);
    fill(255);

    for( int i = 0; i < bullets.size(); ++i ) {
        Bullet b = bullets.get(i);
        b.draw();
    }

    pushMatrix();
    translate(width/2,height/2);
    rotate(ang);
    rect(0, 0, 50, 50);
    popMatrix();
}