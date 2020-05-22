public int compareTo(Edge e) 
{
    if( e.getWeight() > this.weight )
        return 1;
    else if( e.getWeight() == this.weight )
        return 0;
    else //e.getWeight() < this.weight
        return -1
}