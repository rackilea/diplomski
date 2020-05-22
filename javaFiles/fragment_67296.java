public class Test {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Dynamic dynamic = mapper.readValue(new File("simple.json"), Dynamic.class);
        for (String key : dynamic.getMap().keySet()) {
            System.out.println("key: " + key);
            System.out.println("--------");
            List<Map<String, Object>> list = (List<Map<String, Object>>) dynamic.get(key);
            for (Map<String, Object> map : list) {
                for (Map.Entry<String, Object> entry: map.entrySet()) {
                    System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
                }
            }
            System.out.println("========");
        }
    }
}