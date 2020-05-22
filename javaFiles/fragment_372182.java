String values;

void draw()
{
    while ( myPort.available() > 0) { 
        values = myPort.readStringUntil(lf);
    }

    background(0);
    if (values != null)
    {
        noFill();
        stroke(255, 0, 0);
        strokeWeight(1);
        float end = map(float(values), 735, 4160, 0, height); // 735 is lowest value from sensor and 4160 is max. value from sensor
        fill(255, 0, 0);
        ellipse(200, end, 10, 10);
        line(200, 400, 200, end);
    }
}