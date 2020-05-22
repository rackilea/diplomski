public class Test {
private int boxWidth, boxHeight = 50;
private GRect[] rects;
private int first;//keep track of oldest rectangle

public Test()
{
    this.rects = new GRect[10];
    this.first = 0;
}

void drawRects()
{
    //for each rectangle, draw it
}

void addRect()
{
    this.rects[first] = new GRect(boxWidth, boxHeight);
    first++;
    first = first % 10; //keeps it within 0-9 range
}

 }