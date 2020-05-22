public static void convert_to_JSON(File node) {
    File[] subnode = node.listFiles();
    JSONArray ja_root = new JSONArray(); //the node has 2 different directories
    JSONArray ja_pattern = new JSONArray();
    JSONArray ja_library = new JSONArray();
    JSONArray ja_category = new JSONArray();

    for (File filename : subnode) {
        if ("newfileroot".equals(filename.getName()) || "talendfileroot".equals(filename.getName())) { // String[] libraries; 
            File[] libraries = filename.listFiles();
            for (File lib : libraries) {
                File[] categories = lib.listFiles();


                for (File cat : categories) {
                    if (cat.isDirectory()) {
                        File[] patterns = cat.listFiles();

                        for (File pat : patterns) {


                            if (pat.isDirectory()) {
                                ja_pattern.add(pat.getAbsoluteFile().getName());


                            }

                        }
                        //createjson object here - put cat as key and json array as value
                        JSONObject jo2 = new JSONObject();
                        jo2.put(cat.getAbsoluteFile().getName(), ja_pattern);
                        ja_category.add(jo2);
                         ja_pattern = new JSONArray();
                    }

                }
                JSONObject jo3 = new JSONObject();
                jo3.put(lib.getAbsoluteFile().getName(), ja_category);
                ja_library.add(jo3);
                ja_category = new JSONArray();
            }
            JSONObject jo4 = new JSONObject();
            jo4.put(filename.getAbsoluteFile().getName(), ja_library);
            ja_root.add(jo4);

            ja_library = new JSONArray();
        }

    }
    JSONObject jo5 = new JSONObject();
    jo5.put(node.getAbsoluteFile().getName(), ja_root);

    try (FileWriter file = new FileWriter("d:\\file_structure.json")) {
        file.write(jo5.toJSONString());
        file.flush();
    } catch (IOException e) {
    }
}