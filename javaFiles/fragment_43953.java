public class ProbabilityCalculator {

    private NavigableSet<DataPoint> points;

    private ProbabilityCalculator(NavigableSet<DataPoint> points) {
        this.points = points;
    }

    private static class P {
        public final DataPoint left;
        public final Event leftEvent;
        public final DataPoint right;
        public final Event rightEvent;

        public P(DataPoint left, Event leftEvent, DataPoint right, Event rightEvent) {
            this.left = left;
            this.leftEvent = leftEvent;
            this.right = right;
            this.rightEvent = rightEvent;
        }

        public boolean equals(Object o) {
            if(!(o instanceof P)) return false;
            P p = (P) o;

            if(!(this.leftEvent == null ? p.leftEvent == null : this.leftEvent.equals(p.leftEvent)))
                return false;
            if(!(this.rightEvent == null ? p.rightEvent == null : this.rightEvent.equals(p.rightEvent)))
                return false;

            return this.left.equals(p.left) && this.right.equals(p.right);
        }

        public int hashCode() {
            int result = 93;

            result = 31 * result + this.left.hashCode();
            result = 31 * result + this.right.hashCode();
            result = this.leftEvent != null ? 31 * result + this.leftEvent.hashCode() : 31 * result;
            result = this.rightEvent != null ? 31 * result + this.rightEvent.hashCode() : 31 * result;

            return result;
        }
    }

    private Map<P, Double> usedPs = new HashMap<P, Double>();

    private static class F {
        public final DataPoint left;
        public final Event leftEvent;
        public final NavigableSet<DataPoint> dataPointsToLeft;

        public F(DataPoint dataPoint, Event dataPointEvent, NavigableSet<DataPoint> dataPointsToLeft) {
            this.dataPoint = dataPoint;
            this.dataPointEvent = dataPointEvent;
            this.dataPointsToLeft = dataPointsToLeft;
        }

        public boolean equals(Object o) {
            if(!(o instanceof F)) return false;
            F f = (F) o;
            return this.dataPoint.equals(f.dataPoint) && this.dataPointEvent.equals(f.dataPointEvent) && this.dataPointsToLeft.equals(f.dataPointsToLeft);
        }

        public int hashCode() {
            int result = 7;

            result = 31 * result + this.dataPoint.hashCode();
            result = 31 * result + this.dataPointEvent.hashCode();
            result = 31 * result + this.dataPointsToLeft.hashCode();

            return result;
        }

    }

    private Map<F, Double> usedFs = new HashMap<F, Double>();

    private Double p(DataPoint right, Event rightEvent, DataPoint left, Event leftEvent) {
        P newP = new P(right, rightEvent, left, leftEvent);

        if(this.usedPs.containsKey(newP)) return usedPs.get(newP);


        // do some stuff

        usedPs.put(newP, result);
        return result;

    }

    private Double f(DataPoint right, Event rightEvent) {

        NavigableSet<DataPoint> dataPointsToLeft = dataPoints.headSet(right, false);

        F newF = new F(right, rightEvent, dataPointsToLeft);

        if(usedFs.containsKey(newF)) return usedFs.get(newF);

        DataPoint left = points.lower(right);

        Double result = 0.0;

        if(left.isLefthandNode()) {
            result = 0.25 * p(right, rightEvent, left, null);
        } else if(left.isQ()) {
            result = p(right, rightEvent, left, left.getQEvent()) * f(left, left.getQEvent(), points);
        } else { // if M_k
            for(Event leftEvent : left.getEvents())
                result += p(right, rightEvent, left, leftEvent) * f(left, leftEvent, points);
        }

        usedFs.put(newF, result)

        return result;
    }

    public Double S() {
        return f(points.last(), points.last().getRightNodeEvent(), points)
    }

    public static probabilityOfQ(DataPoint q, NavigableSet<DataPoint> points) {
        ProbabilityCalculator pc = new ProbabilityCalculator(points);

        Double S1 = S();

        points.add(q);

        Double S2 = S();

        return S2/S1;

    }
}