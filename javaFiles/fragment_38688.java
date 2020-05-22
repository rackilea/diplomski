import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public abstract class AStar<T> {

    private class Path<T> implements Comparable {

        public T point;
        public Double f;
        public Double g;
        public Path<T> parent;

        public Path() {
            parent = null;
            point = null;
            g = f = 0.0;
        }

        public Path(Path<T> p) {
            this();
            parent = p;
            g = p.g;
            f = p.f;
        }

        @Override
        public int compareTo(Object o) {
            AStar.Path p = (AStar.Path) o;
            return (int) (f - p.f);
        }

        public T getPoint() {
            return point;
        }

        public void setPoint(T p) {
            point = p;
        }
    }

    protected abstract boolean isGoal(T node);

    protected abstract Double g(T from, T to);

    protected abstract Double h(T from, T to);

    protected abstract List<T> generateSuccessors(T node, T parent);
    private PriorityQueue<AStar.Path> paths;
    private HashMap<T, Double> mindists;
    private Double lastCost;
    private int expandedCounter;

    public int getExpandedCounter() {
        return expandedCounter;
    }

    public AStar() {
        paths = new PriorityQueue<>();
        mindists = new HashMap<>();
        expandedCounter = 0;
        lastCost = 0.0;
    }

    protected Double f(AStar.Path p, T from, T to) {
        Double g = g(from, to) + ((p.parent != null) ? p.parent.g : 0.0);
        Double h = h(from, to);

        p.g = g;
        p.f = g + h;

        return p.f;
    }

    private void expand(Path<T> path) {
        if (expandedCounter > 1000000) {
            return;
        }
        T p = path.getPoint();
        Double min = mindists.get(path.getPoint());


        if (min == null || min.doubleValue() > path.f.doubleValue()) {
            mindists.put(path.getPoint(), path.f);
        } else {
            return;
        }

        List<T> successors = generateSuccessors(p, path.parent != null ? path.parent.getPoint() : null);

        for (T t : successors) {
            AStar.Path newPath = new AStar.Path(path);
            newPath.setPoint(t);
            f(newPath, path.getPoint(), t);
            paths.offer(newPath);
        }

        expandedCounter++;
    }

    public Double getCost() {
        return lastCost;
    }

    public List<T> compute(T start) {
        try {
            AStar.Path root = new AStar.Path();
            root.setPoint(start);

            /*
             * Needed if the initial point has a cost.
             */
            f(root, start, start);

            expand(root);

            for (;;) {
                Path<T> p = paths.poll();

                if (p == null) {
                    lastCost = Double.MAX_VALUE;
                    return null;
                }

                T last = p.getPoint();

                lastCost = p.g;

                if (isGoal(last)) {
                    LinkedList<T> retPath = new LinkedList<T>();

                    for (Path<T> i = p; i != null; i = i.parent) {
                        retPath.addFirst(i.getPoint());
                    }

                    return retPath;
                }
                expand(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}