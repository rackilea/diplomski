File lastModified = null;
    for (File file : directory.listFiles()) {
        if (file.isFile()) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file)));
            try {
                for (String line; (line = reader.readLine()) != null;) {
                    if (line.contains(queryUser)) {
                        arr.add(file);
                        if (lastModified == null
                                || file.lastModified() > lastModified
                                        .lastModified()) {
                            lastModified = file;
                        }
                    }
                }
            } finally {
                reader.close();
            }
        }
    }