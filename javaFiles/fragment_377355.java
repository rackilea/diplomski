for(Node neighbour : neighbours)
{
    for(Node n2 : neighbours) {
        if(neighbour == n2) continue;
        if(! neighbour.neighbours().contains(n2)) return false;
    }
}