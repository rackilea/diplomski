double volume;
double volumeUsed=2*volume;
if (sideLength>=0)
{
    volume=sideLength*sideLength*sideLength; //<--initialised (too late)
}
else
{
   volume=0;
}
return volume;