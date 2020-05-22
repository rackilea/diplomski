public class UpdateJson {
    public static void main(String[] args) throws IOException {
        addObject("example.json", "GENERAL", arrayOf(arrayOf("POS_X","2"), arrayOf("POS_Y","4")));
    }

    private static void addObject(String fileName, String newObjName, String newObjValue) throws IOException {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> existingJson = gson.fromJson(new JsonReader(new FileReader(new File(fileName))), type);
        existingJson.put(newObjName, newObjValue);
        try (FileWriter writer = new FileWriter(new File(fileName))) {
            writer.write(gson.toJson(existingJson));
        }
    }

    private static String arrayOf(String s1, String s2) {
        return "[" + s1 + ", " + s2 + "]";
    }
}