public int compareTo(Octagon otherOctagon)
{
    if(this.getArea() == octangon.getArea())
        return 0;
    else if(this.getArea() < octangon.getArea())
        return -1;
    else
        return 1; 
}