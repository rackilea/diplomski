Path path = Paths.get("/", "user", "guest", "workspace", 
    "test", "src", "main", "java", "Test.java");
Path other = ...
Path relPath = other.relativize(path);

//    relPath.toString(); // print it
//    relPath.toFile();   // get a file