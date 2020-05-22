void recurseMD5(File it, List<String> hashes) {
     if (it.isDirectory) {
        for (File f : it.listFiles()) recurseMD5(f, hahses);
     }
     else {
         // process MD5 hash of file
     }
}