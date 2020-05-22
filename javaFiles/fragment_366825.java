Process process = new ProcessBuilder(
    "find", "-L", "/dir/*", "-type", "d", "-prune", "-o", "-type", "l").start();

long brokenLinkCount;
try (BufferedReader lineReader =
    new BufferedReader(new InputStreamReader(process.getInputStream()))) {

    brokenLinkCount = lineReader.lines().count();
}