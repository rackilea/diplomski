void cleanDirectory(File dir) {
    for (File file: dir.listFiles()) {
        if(file.getName().equals("Result folder") || file.getName().equals("Report folder")) {
            //do nothing
        } else {
            //delete file
            file.delete();
        }

    }