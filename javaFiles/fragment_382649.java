File dir = parent;
    for (int j=0; j < depth-1; j++) {
        String dirName = String.format("%03d", currentA[j]);
        dir = new File(dir, dirName);
    }
    String fileName = prefix + String.format("%03d", currentA[depth]) + suffix;
    File file = new File(dir, fileName);