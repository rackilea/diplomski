private static ArrayList<String> collectFiles(File folder, String relativePath) {

        ArrayList<String> resultList = new ArrayList<>();
        resultList.add(relativePath);

        if (!folder.isDirectory())
            return resultList;

        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null) {
            return new ArrayList<>();
        }

        for (File f : listOfFiles) {
            if (f.isDirectory()) {
                ArrayList<String> currentResults = collectFiles(f, relativePath + File.separator + f.getName());
                resultList.addAll(currentResults);
            } else {
                resultList.add(relativePath + File.separator + f.getName());
            }
        }

        return resultList;
    }