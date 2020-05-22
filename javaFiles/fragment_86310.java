class Maze {

    private static char NUMBER_SIGN = '#', DOT = '.', START = 'S';
    private static char EXIT = 'E', PATH = '1';
    private static Node[][] nodes;
    private static Node start;
    private static boolean[][] visited; //no need to use Boolean
    //exit holds the same information as Node.blocked. No need to duplicate
    //private static boolean[][] blocked;
    //exit holds the same information as Node.exit. No need to duplicate
    //private static boolean[][] exits;

    private static int mazeWidth, mazeHeight, startH, startW; //use meaningful names
    private static List<List<Node>> paths;

    public static void main(String args[]) {

        mazeWidth = 21;//use meaningful names
        mazeHeight = 21;
        startH = 9; startW = 10;

        String[] mazeData = getMazeData()  ;
        makeMaze(mazeData);
        drawMaze(); //draw maze as built from input data

        List<Node> result = new ArrayList<>();
        paths = new ArrayList<>();

        findExits(start, nodes, visited, mazeWidth, mazeHeight, result, paths);

        if (!result.isEmpty()) {
            Collections.sort(result, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (Integer.compare(o1.x, o2.x) == 0) {
                        return Integer.compare(o1.y, o2.y);
                    } else {
                        return Integer.compare(o1.x, o2.x);
                    }
                }
            });
        }
        drawAllPaths(); // see all paths found
        List<Node> shortestPath = getShortestPath();
        drawShortestPath(shortestPath);
    }

    private static void drawMaze() {

        System.out.println("***************************************************");
        System.out.println("Maze as defined by input");
        System.out.println("***************************************************");
        drawMaze(null);
    }

    private static void drawAllPaths() {

        for (List<Node> path : paths) {
            System.out.println("***************************************************");
            System.out.println("Path to exit ["
            + path.get(0).x + "," + path.get(0).y + "] length:"+ path.size());
            System.out.println("***************************************************");
            drawMaze(path);
        }
    }

    private static void drawShortestPath(List<Node> path) {

        System.out.println("***************************************************");
        System.out.println("Shortest path is to exit ["
        + path.get(0).x + "," + path.get(0).y + "] length:"+ path.size());
        System.out.println("***************************************************");
        drawMaze(path);
    }

    private static void drawMaze(List<Node> path) {

        for(Node[] row : nodes ) {

            for(Node node : row) {

                char c = node.getGraphics();
                if ((path != null) && path.contains(node)) {c = PATH;}
                System.out.print(c);
            }
            System.out.println("");
        }
    }

    private static void makeMaze(String[] mazeData) {

        nodes = new Node[mazeHeight][mazeWidth];
        visited = new boolean[mazeHeight][mazeWidth];

        for (int height = 0; height < mazeHeight; height++) {
            String row = mazeData[height];
            for (int width = 0; width < mazeWidth; width++) {
                Node node = new Node(height, width);
                node.blocked = row.charAt(width) == NUMBER_SIGN;
                visited[width][height] = false;
                node.exit = (!node.blocked) && ((height == (mazeHeight - 1)) ||
                                (width == (mazeWidth - 1)) || (height == 0) || (width == 0));
                nodes[height][width] = node;
            }
        }
        start = nodes[startH][startW];//no need to set it in the loop
    }

    //use boolean instead of Boolean
    private static void findExits(Node start, Node[][] nodes,
            boolean[][] visited, int W, int H, List<Node> result, List<List<Node>> paths) {

        int x = start.x;
        int y = start.y;
        visited[x][y] = true;
        if (start.exit) {
            result.add(start);
            visited[x][y] = false;
            List<Node> path = new ArrayList<>();
            while (start.parent != null) {
                path.add(start);
                start = start.parent;
            }
            path.add(start);
            paths.add(path);
        }
        //TOP
        if ((y - 1) >= 0) {
            if (!visited[x][y - 1] && (!nodes[x][y - 1].blocked)) {
                nodes[x][y - 1].parent = start;
                findExits(nodes[x][y - 1], nodes, visited, W, H, result, paths);
            }
        }
        //BOT
        if ((y + 1) < H) {
            if (!visited[x][y + 1] && (!nodes[x][y + 1].blocked)) {
                nodes[x][y + 1].parent = start;
                findExits(nodes[x][y + 1], nodes, visited, W, H, result, paths);
            }
        }
        //LEFT
        if ((x - 1) >= 0) {
            if (!visited[x - 1][y] && (!nodes[x - 1][y].blocked)) {
                nodes[x - 1][y].parent = start;
                findExits(nodes[x - 1][y], nodes, visited, W, H, result, paths);
            }
        }
        //RIGHT
        if ((x + 1) < W) {
            if (!visited[x + 1][y] && (!nodes[x + 1][y].blocked)) {
                nodes[x + 1][y].parent = start;
                findExits(nodes[x + 1][y], nodes, visited, W, H, result, paths);
            }
        }
    }

    public static class Node {

        public int x, y;
        boolean blocked = false;
        boolean exit = false;
        Node parent = null;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Node other = (Node) obj;
            if (x != other.x) {
                return false;
            }
            if (y != other.y) {
                return false;
            }
            return true;
        }

        //it is simpler to have Node return its graphic representation
        char getGraphics() {

            char c = blocked ? NUMBER_SIGN : DOT;
            if(equals(start)) { c=START;}
            else if (exit) { c=EXIT;}

            return c;
        }
    }

    private static List<Node> getShortestPath() {
        //initialize with an arbitrary path
        List<Node> shortest = paths.get(0);
        for (List<Node> path : paths) {
            if(path.size() < shortest.size()) {
                shortest = path;
            }
        }
        return shortest;
    }

    private static String[] getMazeData() {

        return  new String[] {
                "##########.##########",
                "..#...........#.....#",
                "#.#.#########.#.###.#",
                "#...#.........#.#...#",
                "###############.#.###",
                "#.....#.......#.#...#",
                "#.#######.###.#.#.#.#",
                "#...#...#...#...#.#..",
                "###.###.###.###.#.#.#",
                "#.#.#.#...#.#...#.#.#",
                "#.#.#.#.#.#.#.###.#.#",
                "#...#.#.#.#.#...#.#.#",
                "#####.###.#.#####.###",
                "#.#.......#.#...#...#",
                "#.#.#######.#.#.###.#",
                "#.#.#...#...#.#.#...#",
                "#.#.###.#.#####.#####",
                "#.#.................#",
                "#.##.####.#########.#",
                "#.........#..........",
                "####.######.#########"
                };
    }
}