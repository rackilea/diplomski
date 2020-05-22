public static void nJSON(String username ) {

    File file = new File("src/jsonFiles/" +  username + ".json");

    if (file.isDirectory()) {
        System.err.println(username + ".json exist and is a directory.");
        return;
    }

    if(!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
        System.err.println("Failed to create directory " + file.getParent());
        return;
    }

    FileWriter writer = null;
    try{
        json.put("Username", username);
        json.put("Password", mainFiles.windowsSrc.UserInfo.password);

        writer = new FileWriter(file);
        writer.write(json.toJSONString());
        writer.close();

        System.out.println(username + ".json created.");

    } catch(IOException e){
        e.printStackTrace();
    } finally {
        if(writer != null) {
            try {
                writer.close();
            } catch(IOException ignore) { }
        }
    }
}