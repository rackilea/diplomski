public static void main(String[] args) throws Exception{

    // Create a new file object for the first file and get bytes from file
    File file = new File("C:\\Users\\ihene\\Desktop\\my-photo.jpg");
    byte[] buff1 = getBytesFromFile(file);

    // Create a new file object for the second file and get bytes from file
    File file2 = new File("C:\\Users\\ihene\\Desktop\\esan-caleb.jpg");
    byte[] buff2 = getBytesFromFile(file2);

    // Data needed to use the Face++ Compare API
    String url = "https://api-us.faceplusplus.com/facepp/v3/compare";
    HashMap<String, String> map = new HashMap<>();
    HashMap<String, byte[]> byteMap = new HashMap<>();
    map.put("api_key", "dam4ZdTkSsZOUAiR4oQpP3DRnjEz1fcD");
    map.put("api_secret", "0MOCfpum1Lec06EMOzuJPOEa_EhM4Ttg");

    byteMap.put("image_file1", buff1);
    byteMap.put("image_file2", buff2);

    try {
        // Connecting and retrieving the JSON results
        byte[] bacd = post(url, map, byteMap);
        String jsonStr = new String(bacd);

        // Parse the JSON and get the confidence value
        JSONObject obj = new JSONObject(jsonStr);
        double confidence = obj.getDouble("confidence");
        System.out.println(confidence);
    } catch (Exception e) {
        e.printStackTrace();
    }
}