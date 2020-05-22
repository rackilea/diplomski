// exactly as you have them:
@Override
public void paint(Graphics g) {
    super.paint(g);
    drawRandomLines(g);
}
// Changed. Do no "sleep" here, or you'll freeze the GUI
// just draw whatever your model is/has.
private void drawRandomLines(Graphics g) {
    for( Line line : lines ){
        if( line != null ){ 
            g.drawLine( line.x1, line.y1, line.x2, line.y2 );
        }
    }
}