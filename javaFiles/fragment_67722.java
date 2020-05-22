class Line {
    ArrayList<Double> values = new ArrayList<Double>();
}

public class Calculating {
    ArrayList<Line> lineY = new ArrayList<Line>();

    void someMethod() {
        ArrayList<Double> lineNewY = new ArrayList<Double>;
        for( Line line : lineY )
            lineNewY.addAll( line.values );

        // lineNewY now has all the doubles
    }
}