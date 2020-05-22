int rand = random.nextInt(8); //0..7
if (rand < 3) //0,1,2
{
    newx++;
}
else if (rand < 6) //3,4,5
{
    newx--;
}

//change y according to number
if(rand % 3 == 0) //0,3,6
{
    newy++;
}
else if(rand % 3 == 1) //1,4,7
{
    newy--;
}