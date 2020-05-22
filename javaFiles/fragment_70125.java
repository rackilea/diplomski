public class FindShortestPath {

    //the map is represented as a graph, and the graph is represented as an adyacent matrix
    int map[][] = {{-1, 1, 1, 20},    //-1 = there is no edge between two vertexs
                  {-1, -1, 3, 1},
                  {-1, -1, -1, 1},
                  {-1, -1, -1, -1}};

    int distSol = Integer.MAX_VALUE;                    //we want to minimize this value
    List<Integer> solution = new ArrayList<Integer>();  //path solution

    public static void main(String[] args) {
        new FindShortestPath().start();
    }

    void start() {
        /* In this case we find shortest path from 0 to 3 */
        findShortestPath(new boolean[map.length], 0, 3, 0, new ArrayList<Integer>());

        System.out.println("Distance: " + distSol);
        System.out.println(solution.toString());
    }

    /**
     * 
     * @param visit   auxiliary array to mark visited
     * @param c       actual vertex
     * @param destiny destiny vertex
     * @param distAct actual distance traveled
     * @param path    actual path traveled
     */
    void findShortestPath(boolean visit[], int c, int destiny, int distAct, List<Integer> path) {
        if (c == destiny) {                             //base case: we reach destiny
            if (distAct <= distSol) {                   //check if actual distance is better than solution                
                distSol = distAct;
                solution = new ArrayList<Integer>(path);   //replace old solution
                solution.add(destiny);
            }
        } else {                                        //recursive case
            path.add(c);                                //add actual vertex as a possible candidate into actual path
            visit[c] = true;

            for (int i = 0; i < map.length; i++) {      //visit every adyacent vertex that was no visited yet
                if (map[c][i] != -1 && !visit[i]) {
                    findShortestPath(visit, i, destiny, distAct + map[c][i], path);
                }
            }

            path.remove(path.size() - 1);               //remove this vertex from the path
            visit[c] = false;
        }
    }
}