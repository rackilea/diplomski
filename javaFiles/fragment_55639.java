public static final String JSON_PATH = "/Users/dawid/Workspace/Test/test.json";

Gson gson = new Gson();
BufferedReader br = new BufferedReader(new FileReader(JSON_PATH));
Type type = new TypeToken<List<Model>>(){}.getType();
List<Model> models = gson.fromJson(br, type);