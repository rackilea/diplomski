package playground;

import java.util.*;

public class PathFinder extends AStar<PathFinder.Node> {

    private int[][] map;
    private int endx;
    private int endy;

    public static class Node {

        public int x;
        public int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ") ";
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public PathFinder(int[][] map, int endx, int endy) {
        this.map = map;
        this.endx = endx;
        this.endy = endy;
    }

    protected boolean isGoal(Node node) {
        return (node.x == endx) && (node.y == endy);
    }

    protected Double g(Node from, Node to) {

        if (from.x == to.x && from.y == to.y) {

            //   System.out.println("To x1 " + to.x);
            //     System.out.println("To y1 " + to.y);
            return 0.0;
        }

        if (map[to.y][to.x] == 1) {
            //System.out.println("To x2 " + to.x);
            //  System.out.println("To y2 " + to.y);

            return 1.0;
        }

        return Double.MAX_VALUE;
    }

    protected Double h(Node from, Node to) {
        int dx = Math.abs(endx - to.x);
        int dy = Math.abs(endy - to.y);
        return new Double(Math.sqrt(dx * dx) + (dy * dy));
        //return new Double(Math.abs(endx - to.x) + Math.abs(endy - to.y));
    }

    @Override
    protected List<Node> generateSuccessors(Node node, Node parent) {
        List<Node> ret = new LinkedList<Node>();
        int x = node.x;
        int y = node.y;
        if (y < map[0].length - 1 && map[y + 1][x] == 1 && (parent == null || (parent != null && !(parent.x == x && parent.y == y + 1)))) {
            ret.add(new Node(x, y + 1));
        }

        if (x < map.length - 1 && map[y][x + 1] == 1 && (parent == null || (parent != null && !(parent.x == x + 1 && parent.y == y)))) {
            ret.add(new Node(x + 1, y));
        }

        if (y != 0 && map[y - 1][x] == 1 && (parent == null || (parent != null && !(parent.x == x && parent.y == y - 1)))) {
            ret.add(new Node(x, y - 1));
        }

        if (x != 0 && map[y][x - 1] == 1 && (parent == null || (parent != null && !(parent.x == x - 1 && parent.y == y)))) {
            ret.add(new Node(x - 1, y));
        }

        return ret;
    }

    public static void main(String[] args) {
        int ammountOfBlocks = 200;
        int width = 25;
        int length = 25;
        int startX = 1;
        int startY = 1;
        int endX = 24;
        int endY = 24;
        int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        int a = map.length;
        int b = map[0].length;
        int[][] map2 = new int[b][a];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map2[j][i] = map[i][j];
            }
        }
        PathFinder pf = new PathFinder(map, endX, endY);


        /*
         * for(int i = 0; i < map.length; i++){ for(int j = 0; j <
         * map[0].length; j++) System.out.print(map[i][j] + " ");
         * System.out.println(); }
         */

        long begin = System.currentTimeMillis();

        List<Node> nodes = pf.compute(new PathFinder.Node(startX, startY));

        long end = System.currentTimeMillis();


        System.out.println("Time = " + (end - begin) + " ms");
        //System.out.println("Expanded = " + pf.getExpandedCounter());
        System.out.println("Cost = " + pf.getCost());

        if (nodes == null) {
            System.out.println("No path");
        } else {

            for (int i = 0; i < nodes.size(); i++) {
                Node n = nodes.get(i);
                int x = n.getX();
                int y = n.getY();
                map[x][y] = 4;
            }

            for(int i = 0; i < map.length; i++){ 
                for(int j = 0; j < map[0].length; j++) 
                    System.out.print(map[i][j] + " ");

                System.out.println(); 
            }
        }
    }
}