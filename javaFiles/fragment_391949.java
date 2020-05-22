public int isLargerThan(Relatable other) {
    RectanglePlus otherRect 
        = (RectanglePlus)other;
    if (this.getArea() < otherRect.getArea())
        return -1;
    else if (this.getArea() > otherRect.getArea())
        return 1;
    else
        return 0;               
}