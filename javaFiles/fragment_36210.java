public class SearchComparison {

public static void main(String[] args) {
    StopWatch watch = new StopWatch();
    ArrayUtilities utilities = new ArrayUtilities();
    watch.start();
    utilities.generateRandom(5);
    watch.stop();
}

}