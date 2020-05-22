import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class PointSet {
public static final int W = 2;
Area area = new Area();

public void add( double x, double y ){
    area.add( new Area( new Rectangle2D.Double( x-W, y-W,2*W, 2*W ) ) );
}
public void plot(){
    Board board = new Board();
    board.go( area );
}
public static void main( String[] args ){
    PointSet ps = new PointSet();
    ps.add( 4, 5);
    ps.add( 3, 3);
    ps.add( 3, 1);
    ps.add( 5, 0);
    ps.add( 6, 1);
    ps.add( 6, 3);
    ps.plot();
}
}