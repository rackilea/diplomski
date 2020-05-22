public class Main {

    private static List<String> values = new ArrayList();

    public static void main(String[] args) {
        try {
            JSONObject jsonObject = new JSONObject(new String(Files.readAllBytes(Paths.get("test.json"))));

            findValues(jsonObject);

            values.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void findValues(Object root) {

        if (root instanceof JSONObject) {
            Iterator<String> keys = ((JSONObject)root).keys();

            while (keys.hasNext()) {
                String key = keys.next();

                if ("pieceLabel".equals(key)) {
                    values.add(((JSONObject)root).getString(key));
                }
                else {
                    Object o = ((JSONObject)root).get(key);
                    findValues(o);
                }
            }
        }
        else if (root instanceof JSONArray) {
            for (Object o : (JSONArray)root) {
                findValues(o);
            }
        }
    }
}