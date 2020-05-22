File cacheFile = new File(getFilesDir(), "test.cache");
    List<String> titleArray = new ArrayList<String>(Arrays.asList("a", "b", "c"));

    if (!cacheFile.exists()) {
        try {
            FileWriter out = new FileWriter(cacheFile);
            for (int i = 0; i < titleArray.size(); i++) {
                out.write(titleArray.get(i));
                out.write(System.getProperty("line.separator"));
            }
            out.close();
        } catch (Exception e) {
            Log.e("Test", e.getMessage());
        }
    }