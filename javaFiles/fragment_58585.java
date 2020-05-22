public class Test {

    public static void main(String[] args) {        
        List<Interval> interval = Arrays.asList(new Interval(0, 10), new Interval(15, 20));
        List<Interval> remove = Arrays.asList(new Interval(2, 3), new Interval(5, 6));

        List<AnnotatedPoint> queue = initQueue(interval, remove);       
        List<Interval> result = doSweep(queue);

        // print result
        for (Interval i : result) {
            System.out.println(i);
        }
    }

    private static List<AnnotatedPoint> initQueue(List<Interval> interval, List<Interval> remove) {
        // annotate all points and put them in a list
        List<AnnotatedPoint> queue = new ArrayList<>();
        for (Interval i : interval) {
            queue.add(new AnnotatedPoint(i.start, PointType.Start));
            queue.add(new AnnotatedPoint(i.end, PointType.End));
        }
        for (Interval i : remove) {
            queue.add(new AnnotatedPoint(i.start, PointType.GapStart));
            queue.add(new AnnotatedPoint(i.end, PointType.GapEnd));
        }

        // sort the queue
        Collections.sort(queue);

        return queue;
    }

    private static List<Interval> doSweep(List<AnnotatedPoint> queue) {
        List<Interval> result = new ArrayList<>();

        // iterate over the queue       
        boolean isInterval = false; // isInterval: #Start seen > #End seen
        boolean isGap = false;      // isGap:      #GapStart seen > #GapEnd seen
        int intervalStart = 0;  
        for (AnnotatedPoint point : queue) {
            switch (point.type) {
            case Start:
                if (!isGap) {                   
                    intervalStart = point.value;
                }
                isInterval = true;
                break;
            case End:
                if (!isGap) {                   
                    result.add(new Interval(intervalStart, point.value));
                }
                isInterval = false;
                break;
            case GapStart:
                if (isInterval) {                   
                    result.add(new Interval(intervalStart, point.value));
                }               
                isGap = true;
                break;
            case GapEnd:
                if (isInterval) {
                    intervalStart = point.value;
                }
                isGap = false;
                break;
            }
        }

        return result;
    }
}