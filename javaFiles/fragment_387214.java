// sample gradle task to execute a java jar
task runFromGradle() {
    print("java -jar myJar.jar path/to/some.csv".execute().text)
}

// some sample class with a main that accepts args. first arg is the csv path
class Scratch {
    public static void main(String[] args) {
        String csvPath = args[0];
        Reader reader = Files.newBufferedReader(Paths.get(csvPath));
        // do whatever with reader...
    }
}

# from command line
$ gradle runFromGradle