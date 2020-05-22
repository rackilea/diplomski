import java.util.*;
public class SquareSolver {
/**
 * The LRU_Cache data structure is useful in a LOT of optimization problems, where storing all the problems you've solved so far
 * is infeasible, but there's significant time savings to be had if your program can
 * realize "Wait, I've solved this sub-problem already", and just re-use earlier answers.
 * It stores things, until it gets above LRUCacheSize, then it automatically ejects the least recently used entry.
 * This is strictly an optimization, because things get ejected from the cache automatically, you should not rely on
 * presence (or not) of an element for correctness.
 */
private HashMap<Integer, LRUCache> leastRecentlyUsedCache;
private Map<Integer, Integer> bestShortPathScores;
private Map<Integer, Integer> depthEarlyCutoffsMap;
private Map<Integer, Integer> depthCacheHitsMap;
private int squareSize, targetLength;
private Map<Coords, Integer> coordScores;
private Set<Coords> neighborOffsets;
private Path bestPath;
private boolean isLongPath;
private long startTime;
private long timeout;
private class LRUCache extends LinkedHashMap<Path, Integer>{
    private int LRUCacheSize;
    LRUCache(int LRUCacheSize){
        super(LRUCacheSize * 4 / 3, 0.75f, true);
       this.LRUCacheSize = LRUCacheSize;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > LRUCacheSize;
    }
}
public SquareSolver(int LRUCacheSize, int squareSize, int targetLength) {
    neighborOffsets = new HashSet<>(Arrays.asList(new Coords[]{new Coords(-1, 0), new Coords(1, 0), new Coords(0, -1), new Coords(0, 1)}));
    this.targetLength = targetLength;
    this.squareSize = squareSize;
    leastRecentlyUsedCache = new HashMap<>();
    for(int i = 0; i <= targetLength; i++) {
        leastRecentlyUsedCache.put(i, new LRUCache(LRUCacheSize / targetLength));
    }
    coordScores = new HashMap<>();
}

public static void main(String[] args) {
    int[][] testSquare = new int[][]{
            {50, 54, 46, 55, 45, 56, 44, 53, 47, 59, 41, 60, 40, 59, 41, 59},
            {47, 57, 46, 49, 52, 46, 53, 47, 53, 41, 59, 40, 60, 41, 59, 41},
            {56, 42, 54, 51, 48, 54, 47, 53, 53, 57, 48, 54, 49, 57, 46, 59},
            {48, 50, 52, 54, 56, 58, 57, 47, 48, 49, 48, 47, 46, 53, 52, 51},
            {50, 56, 50, 48, 49, 50, 51, 59, 42, 60, 39, 62, 38, 63, 38, 50},
            {60, 40, 50, 50, 50, 50, 60, 40, 55, 45, 55, 45, 56, 44, 56, 44},
            {60, 45, 46, 37, 56, 50, 43, 39, 50, 53, 56, 39, 50, 58, 39, 49},
            {26, 56, 54, 38, 48, 50, 67, 64, 32, 54, 50, 49, 48, 47, 46, 45},
            {28, 45, 35, 57, 54, 34, 34, 32, 64, 57, 58, 74, 24, 64, 34, 50},
            {40, 50, 60, 54, 45, 56, 46, 47, 35, 36, 39, 27, 38, 50, 51, 52},
            {29, 38, 47, 58, 48, 37, 50, 58, 37, 46, 50, 50, 50, 50, 50, 50},
            {47, 48, 49, 50, 52, 65, 64, 52, 49, 47, 43, 47, 58, 46, 30, 32},
            {59, 47, 47, 56, 65, 34, 45, 56, 75, 24, 35, 45, 56, 65, 50, 54},
            {53, 46, 35, 45, 29, 46, 46, 50, 23, 32, 40, 46, 64, 64, 64, 20},
            {53, 54, 56, 58, 60, 43, 43, 34, 34, 35, 64, 30, 50, 40, 49, 59},
            {52, 12, 17, 50, 63, 62, 62, 64, 50, 51, 52, 57, 43, 44, 42, 69}};
    SquareSolver testSolver = new SquareSolver(500 * 1000, 16, 50);
    Path bestPath = testSolver.solveSquare(testSquare, 30 * 1000);
    System.out.println("Best Score:\t" + bestPath.getScore());
    System.out.println("Best Path:\t" + bestPath.toString());
}

private boolean inSquare(Coords coords) {
    int x = coords.getX();
    int y = coords.getY();
    return x >= 0 && y >= 0 && x < squareSize && y < squareSize;
}

public void solveSquareHelper(Path currentPath) {
    // Base Case
    if (currentPath.size() == targetLength) {
        synchronized (bestPath) {
            if (currentPath.getScore() > bestPath.getScore()) {
                System.out.print(".");
                bestPath = currentPath;
            }
        }
        return;
    }

    // Don't run forever.
    if (System.currentTimeMillis() > startTime + timeout){
        return;
    }

    // Least Recently Used Cache can save us a lot of work
    if (lru_hit(currentPath)) {
        return;
    }

    // Early Cutoff can save us a lot of work too
    if (can_early_cutoff(currentPath)) {
        return;
    }

    // Recursive Case
    expandLegalNeighbors(currentPath);
}

private void expandLegalNeighbors(Path currentPath) {
    Coords currentCoords = currentPath.getCurrentCoords();
    neighborOffsets.stream()
            .map(currentCoords::add)                    // Get all neighbors of current coords
            .filter(this::inSquare)                     // Filter out coords outside the square
            .filter(currentPath::doesNotContain)        // Filter out coords already in currentPath
            .sorted(Comparator.comparing(Coords::getProximityToOrigin)) // This order maximizes the usefulness of LRUCache
            .forEachOrdered(neighbor ->
                    solveSquareHelper(new Path(currentPath, neighbor)));
}

private boolean can_early_cutoff(Path currentPath) {
    int futurePathLength = targetLength - currentPath.size();
    int upperBoundFutureScore = bestShortPathScores.get(futurePathLength);
    if (currentPath.getScore() + upperBoundFutureScore <= bestPath.getScore()) {
        depthEarlyCutoffsMap.put(currentPath.size(), depthEarlyCutoffsMap.get(currentPath.size()) + 1);
        return true;
    } else {
        return false;
    }
}

private boolean lru_hit(Path currentPath) {
    LRUCache currentDepthCache = leastRecentlyUsedCache.get(currentPath.size());
    if (currentDepthCache.containsKey(currentPath)) {
        depthCacheHitsMap.put(currentPath.size(), depthCacheHitsMap.get(currentPath.size()) + 1);
        currentDepthCache.put(currentPath, currentDepthCache.get(currentPath) + 1);
        return true;
    } else {
        currentDepthCache.put(currentPath, 0);
    }
    return false;
}
public Path solveSquare(int[][] square, long timeout){
    Map<Integer, Integer> smallPathScores = new HashMap<>();
    smallPathScores.put(1, -10);
    for(int i =0; i < squareSize; i++){
        for(int j = 0; j < squareSize; j++){
            if(square[i][j] > smallPathScores.get(1)){
                smallPathScores.put(1, square[i][j]);
            }
        }
    }
    Coords fakeCoords = new Coords(-10, -10);
    coordScores.put(fakeCoords, -10);
    Path bestSmallPath = new Path(fakeCoords);
    for(int i = 2; i < targetLength; i++){
        SquareSolver smallSolver = new SquareSolver(500 * 1000, squareSize, i);
        bestSmallPath = smallSolver.solveSquare(square, timeout * i, smallPathScores, bestSmallPath);
        smallPathScores.put(i, bestSmallPath.getScore());
        System.gc();
    }
    return solveSquare(square, timeout * targetLength, smallPathScores, bestSmallPath);
}
public Path solveSquare(int[][] square, long timeout, Map<Integer, Integer> shortPathScores, Path initialBestPath) {
    bestPath = initialBestPath;
    bestShortPathScores = shortPathScores;
    System.out.println("=============================Target Length:\t" + targetLength + "(Timeout:\t" + timeout/60000.0 + " minutes)===========================");
    System.out.println("Best Short Path Scores (for early cutoff):\t" + bestShortPathScores);
    startTime = System.currentTimeMillis();
    this.timeout = timeout;
    depthCacheHitsMap = new HashMap<>();
    depthEarlyCutoffsMap = new HashMap<>();
    for (int i = 1; i < targetLength; i++) {
        depthCacheHitsMap.put(i, 0);
        depthEarlyCutoffsMap.put(i, 0);
    }
    for (int i = 0; i < squareSize; i++) {
        for (int j = 0; j < squareSize; j++) {
            coordScores.put(new Coords(i, j), square[i][j]);
        }
    }
    System.out.print("Expanding from best shorter node");
    expandLegalNeighbors(initialBestPath);
    System.out.println("Starting from every spot");
    coordScores.keySet()
            .stream()
            .sorted(Comparator.comparing(Coords::getProximityToOrigin))
            .forEachOrdered(startingCoords -> solveSquareHelper(new Path(startingCoords)));
    System.out.println();
    System.out.println("Best Path:\t" + bestPath);
    System.out.println("Best Score:\t" + bestPath.getScore());
    System.out.println("LRU Cache stats:\t" + depthCacheHitsMap);
    System.out.println("Early Cutoff stats:\t" + depthEarlyCutoffsMap);
    return bestPath;
}

private class Coords implements Comparable<Coords> {
    private int x, y;
    private double proximityToOrigin;

    Coords(int x, int y) {
        this.x = x;
        this.y = y;
        this.proximityToOrigin = Math.sqrt((x - squareSize/2) * (x - squareSize/2) + (y - squareSize/2) * (y - squareSize/2));
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    double getProximityToOrigin() {
        return proximityToOrigin;
    }

    Coords add(Coords other) {
        return new Coords(this.x + other.x, this.y + other.y);
    }

    @Override
    public int compareTo(Coords o) {
        int xdiff = this.x - o.x;
        if (xdiff == 0) return this.y - o.y;
        else return xdiff;

    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Coords) {
            Coords o = (Coords) other;
            return this.x == o.x && this.y == o.y;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.x * squareSize + this.y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

private class Path {
    private TreeSet<Coords> usedCoords;
    private Coords currentCoords;
    private int score;

    Path(Coords newCoords) {
        this.usedCoords = new TreeSet<>();
        usedCoords.add(newCoords);
        currentCoords = newCoords;
        this.score = coordScores.get(newCoords);
    }

    Path(Path previousPath, Coords newCoords) {
        this(newCoords);
        this.usedCoords.addAll(previousPath.usedCoords);
        this.score += previousPath.score;
    }

    Coords getCurrentCoords() {
        return this.currentCoords;
    }

    int size() {
        return usedCoords.size();
    }

    int getScore() {
        return this.score;
    }

    boolean doesNotContain(Coords coords) {
        return !usedCoords.contains(coords);
    }

    @Override
    public String toString() {
        return this.usedCoords.toString();
    }

    @Override
    public int hashCode() {
        return this.usedCoords.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Path) {
            Path o = (Path) other;
            return this.usedCoords.equals(o.usedCoords) && this.currentCoords.equals(o.currentCoords);
        } else {
            return false;
        }
    }
}
}