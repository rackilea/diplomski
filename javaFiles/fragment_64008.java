//This is line 40    
 private final List<FileDescription> fileList = Collections.synchronizedList(new ArrayList<FileDescription>());

 //This is line 88
 public void doUpload(FileEntryEvent e) {
        FileEntry file = (FileEntry) e.getSource();
        FileEntryResults result = file.getResults();
        for (FileInfo fileInfo : result.getFiles()) {
            if (fileInfo.isSaved()) {
                FileDescription fd =
                        new FileDescription(
                        (FileInfo) fileInfo.clone(), getIdCounter());
                synchronized (fileList) {
                    fileList.add(fd); //This is line 97
                }
            }
        }
    }