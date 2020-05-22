counter = 0;
do
{
   g.drawRect(boxes[counter].x, boxes[counter].y, sizeX, sizeY);
   counter = counter + 1;
} while (counter < maxnum);