final File baseDir = ...;
final ProcessBuilder pb = new ProcessBuilder(
    "find", "-type", "d", "-name", "online"
);
pb.directory(baseDir);

final Process p = pb.start();
// use the Process' InputStream