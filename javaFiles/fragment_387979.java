import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Foo01 {

    public static void main(String[] args) {
        List<SamplePoints> points = new ArrayList<>();

        int maxXY = 100;
        int max = 4;
        for (int i = 0; i < max; i++) {
            int x = (int) (maxXY * Math.random());
            int y = (int) (maxXY * Math.random());
            points.add(new SamplePoints(x, y));
        }

        distance(points);
    }

    private static class SamplePoints {
        private int x;
        private int y;

        public SamplePoints(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    private static class Element implements Comparable<Element> {
        public final int index;
        public final double distance;

        public Element(int index, double distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Element e) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(e.distance));
        }
    }

    public static void distance(List<SamplePoints> points) {

        ArrayList<ArrayList<Double>> distArray = new ArrayList<ArrayList<Double>>(points.size());
        double dist = 0;
        List<Element> elements = new ArrayList<Element>();
        for (int i = 0; i < points.size() - 1; i++) {
            ArrayList<Double> distances = new ArrayList<Double>();
            for (int j = i + 1; j < points.size(); j++) {
                // do your calculations here
                dist = Math.sqrt(Math.pow(points.get(i).getX() - points.get(j).getX(), 2)
                        + Math.pow(points.get(i).getY() - points.get(j).getY(), 2));
                distances.add(dist);// add the distance to the current distances
                                    // list
            }
            distArray.add(distances);//

            System.out.println(distArray.indexOf(distances));
            System.out.println(distances);
            System.out.println();

        }
        System.out.print("Distances: " + distArray);
        System.out.println();
        for (int i = 0; i < distArray.size(); i++) {
            for (int j = 0; j < distArray.get(i).size(); j++) {
                elements.add(new Element(i, distArray.get(i).get(j)));
            }
        }
        Collections.sort(elements);
        for (int i = 0; i < elements.size(); i++) {
            System.out.println("Dist " + elements.get(i).distance + " " + "Index "
                    + elements.get(i).index + " ");
        }
    }
}