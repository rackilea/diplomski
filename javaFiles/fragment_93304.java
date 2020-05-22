class Segment {
    Point start;
    Point end;

    public void translate(int xmove, int ymove) {
        start.translate(xmove,ymove);
        end.translate(xmove,ymove);
    }
}