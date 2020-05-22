class Maze {

    private static char NUMBER_SIGN = '#', DOT = '.', START = 'S';
    private static char EXIT = 'E', PATH = '1';
    private static Node[][] nodes;
    private static Node startNode;
    private static boolean[][] visited; //no need to use Boolean
    //exit holds the same information as Node.blocked. No need to duplicate
    //private static boolean[][] blocked;
    //exit holds the same information as Node.exit. No need to duplicate
    //private static boolean[][] exits;

    private static int mazeRows, mazeCols, startRow, startCol; //use meaningful names
    private static List<List<Node>> paths;

    public static void main(String args[]) {

        mazeCols = 21; mazeRows = 21;//use meaningful and consistent names
        startRow = 9; startCol = 10;        //better keep h,w or height,width all over

        String[] mazeData = getMazeData()  ;
        makeMaze(mazeData);
        drawMaze(); //draw maze as built from input data
        paths = new ArrayList<>();
        findExits(startNode);
        drawAllPaths(); // print all paths found
        List<Node> shortestPath = getShortestPath();
        drawShortestPath(shortestPath);
    }

    private static void drawMaze() {

        System.out.println("*****************************************");
        System.out.println("Maze as defined by input");
        System.out.println("*****************************************");
        drawMaze(null);
    }

    private static void drawAllPaths() {

        for (List<Node> path : paths) {
            System.out.println("*****************************************");
            System.out.println("Path to exit ["
                    + path.get(0).row + "," + path.get(0).col + "] length:"+ path.size());
            System.out.println("*****************************************");
            drawMaze(path);
        }
    }

    private static void drawShortestPath(List<Node> path) {

        System.out.println("*****************************************");
        System.out.println("Shortest path is to exit ["
                + path.get(0).row + "," + path.get(0).col + "] length:"+ path.size());
        System.out.println("*****************************************");
        drawMaze(path);
    }

    private static void drawMaze(List<Node> path) {

        for(Node[] row : nodes ) {
            for(Node node : row) {
                char c = node.getGraphics();
                //overwrite c if node is in path
                if ( (c != EXIT) && ( c != START ) &&
                        (path != null) && path.contains(node)) {c = PATH;}
                System.out.print(c);
            }
            System.out.println("");
        }
    }

    private static void makeMaze(String[] mazeData) {

        nodes = new Node[mazeRows][mazeCols];
        visited = new boolean[mazeRows][mazeCols];

        for (int rowIndex = 0; rowIndex < mazeRows; rowIndex++) {
            String row = mazeData[rowIndex];
            for (int colIndex = 0; colIndex < mazeCols; colIndex++) {
                Node node = new Node(rowIndex, colIndex);
                node.blocked = row.charAt(colIndex) == NUMBER_SIGN;
                visited[rowIndex][colIndex] = false;
                node.exit = (!node.blocked) && ((rowIndex == (mazeRows - 1)) ||
                        (colIndex == (mazeCols - 1)) || (rowIndex == 0) || (colIndex == 0));
                nodes[rowIndex][colIndex] = node;
            }
        }
        startNode = nodes[startRow][startCol];//no need to set it in the loop
    }

    //use boolean instead of Boolean
    private static void findExits(Node node) {

        int row = node.row;
        int col = node.col;

        if(visited[row][col]) { return; }

        if (node.exit) {
            List<Node> path = new ArrayList<>();
            while (node.parent != null) {
                path.add(node);
                node = node.parent;
            }
            path.add(node);
            paths.add(path);
            return; //do not continue to check exit neighbors
        }

        //LEFT
        if ((col - 1) >= 0) {
            Node testNode = nodes[row][col - 1];
            //the following if statement repeats for all directions
            //better put in a method
            if ((testNode.parent == null) && ! testNode.blocked) {
                testNode.parent = node; //parent ! null indicates that cell is tested
                findExits(testNode);
                testNode.parent = null; //set back to null: test finished
            }
        }

        //RIGHT
        if ((col + 1) < mazeCols) {
            Node testNode = nodes[row][col + 1];
            if ((testNode.parent == null) && ! testNode.blocked) {
                testNode.parent = node;
                findExits(testNode);
                testNode.parent = null;
            }
        }

        //TOP
        if ((row - 1) >= 0) {
            Node testNode = nodes[row-1][col];
            if ((testNode.parent == null) && ! testNode.blocked) {
                testNode.parent = node;
                findExits(testNode);
                testNode.parent = null;
            }
        }

        //BOTTOM
        if ((row + 1) < mazeRows) {
            Node testNode = nodes[row+1][col];
            if ((testNode.parent == null) && ! testNode.blocked) {
                testNode.parent = node;
                findExits(testNode);
                testNode.parent = null;
            }
        }

        visited[row][col] = true; //mark as visited after all directions explored
        node.parent = null;
    }

    public static class Node {

        public int row, col;
        boolean blocked = false;
        boolean exit = false;
        Node parent = null;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
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
            if (row != other.row) {
                return false;
            }
            if (col != other.col) {
                return false;
            }
            return true;
        }

        //it is simpler to have Node return its graphic representation
        char getGraphics() {

            char c = blocked ? NUMBER_SIGN : DOT;
            if(equals(startNode)) { c=START;}
            else if (exit) { c=EXIT;}

            return c;
        }

        @Override
        public String toString() {

            return "Node " + row +"-"+ col +" ("+ getGraphics() + ")";
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