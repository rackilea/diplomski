public int getG(){
    // calculate exact distance from start
    if (parent != null){
        return parent.getG() + 1;
    }//end if
    return 0;
} // end getG

public int getH(int endx, int endy){
    // calculate estimated distance to end
    // Since we can walk diagonally we can cover the smallest of
    // dx and dy while covering the longest. The distance is therefore
    // the largest of the two
    return Math.max(Math.abs(this.x - endx), Math.abs(this.y - endy));
} // end getH