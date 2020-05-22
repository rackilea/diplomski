static boolean areFilesEqual (Path file1, Path file2) {
    byte[] f1 = Files.readAllBytes(file1); 
    byte[] f2 = Files.readAllBytes(file2);

    if (f1.length != f2.length) 
      return false;
    else {
        for (int i = 0; i < f1.length; i++) {
          if (f1[i] != f2[i])
              return false;
        }
        return true;
    }
}