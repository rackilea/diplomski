public ArrayList<File> getTextFilesRecursively(File dir) {
    return getTextFilesRecursively(dir, new ArrayList<>());
  }

  private ArrayList<File> getTextFilesRecursively(File dir, ArrayList<File> textFiles) {
    File[] allFilesAndFoldersInDir = dir.listFiles();

    if(textFiles == null) {
      textFiles = new ArrayList<>();
    }

    if (allFilesAndFoldersInDir != null && allFilesAndFoldersInDir.length > 0) {
      for (File fileOrFolderInDir : allFilesAndFoldersInDir) {
        if (fileOrFolderInDir.isDirectory()) {
          getTextFilesRecursively(fileOrFolderInDir, textFiles);
        } else if (fileOrFolderInDir.getName().endsWith(".txt")) {
          textFiles.add(fileOrFolderInDir);
        }
      }
    }

    return textFiles;
  }