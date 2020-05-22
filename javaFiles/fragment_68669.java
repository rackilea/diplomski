int rotationCount = 0;
int translateX ;
int translateY ;
int currentTime = 0;
int circlesOrLines ;
int timeLimit ;
int r;
int g;
int b;
ArrayList values;
int maxValue = 226;
int minValue = 75;
int timeIndex = 0;

void setup () {
    size(500, 700);
    r = 226;
    g = 226;
    b = 75;

    smooth();
    background(0);
    rectMode(CENTER);
    frameRate (10);
    noStroke();
    fill(r, g, b, 30);
    translateX = width/2;
    translateY = height/2;
    timeLimit = 10000;
    circlesOrLines = 0;
    currentTime = millis();


    values = new ArrayList();  
    generateColor ();

}

void draw () {
    background(80);

    fill( values.get( frameCount % values.size()));
    int passedTime = millis() - currentTime;

    translate(translateX % width, translateY % height);

    translateX += 3 % width;
    translateY += 3 % height;

    rotationCount += (PI/2008);
    if (passedTime < timeLimit) {
        makeCircles ();
    }
    else {
        if (passedTime >=20000)
        {
            passedTime = 0;
            currentTime = millis();
        }
        makeLines ();

    }
}
void makeCircles () {

    for (int i = 0; i < 25; i++) {
        rotate (rotationCount);
        ellipse(i+7, i % width, 100, height/2);
    }
}

void makeLines () {
    for (int i = 0; i < 25; i++) {
        rotate (rotationCount);
        rect(i+7, i % width, 100, height/2);
    }
}


void generateColor () 
{

    for (g=g; g>minValue; g--)
    {
        values.add (color(r,g,b,30));
    }
    for (r=r; r>minValue; r--)
    {
        values.add (color(r,g,b,30));
    }
    for (b=b; b<maxValue; b++)
    {
        values.add (color(r,g,b,30));
    }
    for (g=g; g<maxValue; g++)
    {
        values.add (color(r,g,b,30));
    }
    for (r=r; r<maxValue; r++)
    {
        values.add (color(r,g,b,30));
    }
    for (b=b; b>minValue; b--)
    {
        values.add (color(r,g,b,30));
    }
}