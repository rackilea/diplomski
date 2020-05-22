private void addRandomLine(){
    Line line = new Line();
    line.x1  = random.nextInt(500);
    line.y1  = random.nextInt(500);
    line.x2  = random.nextInt(500);
    line.y2  = random.nextInt(500);
    lines[count++] = line;//put it in the next position
    // if we reach the limit, start all over again 
    // from 0
    if( count == lines.length ){
        count = 0;
    } 
}