class MyCaret extends DefaultCaret {

Point lastPoint=new Point(0,0);
public void mouseMoved(MouseEvent e) {
    super.mouseMoved(e);
    lastPoint=new Point(e.getX(),e.getY());
}
public void mouseClicked(MouseEvent e) {
    super.mouseClicked(e);
    getComponent().getHighlighter().removeAllHighlights();
}

protected void moveCaret(MouseEvent e) {
    Point pt = new Point(e.getX(), e.getY());
    Position.Bias[] biasRet = new Position.Bias[1];
    int pos = getComponent().getUI().viewToModel(getComponent(), pt, biasRet);
    if(biasRet[0] == null)
        biasRet[0] = Position.Bias.Forward;
    if (pos >= 0) {
        setDot(pos);
        Point start=new Point(Math.min(lastPoint.x,pt.x),Math.min(lastPoint.y,pt.y));
        Point end=new Point(Math.max(lastPoint.x,pt.x),Math.max(lastPoint.y,pt.y));
        customHighlight(start,end);
    }
}

protected void customHighlight(Point start, Point end) {
    getComponent().getHighlighter().removeAllHighlights();
    int y=start.y;
    int firstX=start.x;
    int lastX=end.x;

    int pos1 = getComponent().getUI().viewToModel(getComponent(), new Point(firstX,y));
    int pos2 = getComponent().getUI().viewToModel(getComponent(), new Point(lastX,y));
    try {
        getComponent().getHighlighter().addHighlight(pos1,pos2,
                 ((DefaultHighlighter)getComponent().getHighlighter()).DefaultPainter);
    }
    catch (Exception ex) {
        ex.printStackTrace();
    }
    y++;
    while (y<end.y) {
        int pos1new = getComponent().getUI().viewToModel(getComponent(), new Point(firstX,y));
        int pos2new = getComponent().getUI().viewToModel(getComponent(), new Point(lastX,y));
        if (pos1!=pos1new)  {
            pos1=pos1new;
            pos2=pos2new;
            try {
                getComponent().getHighlighter().addHighlight(pos1,pos2,
                         ((DefaultHighlighter)getComponent().getHighlighter()).DefaultPainter);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        y++;
    }
}
}