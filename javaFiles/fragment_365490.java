public class Test {    
    public static void main(String args[] ) throws Exception {
        Gson gson = new Gson();
        List<Data> list = gson.fromJson(new BufferedReader(new FileReader("myJson.json")), new TypeToken<List<Data>>(){}.getType());
        Map<String, List<Data>> groupedMap = list.stream().collect(Collectors.groupingBy(Data::getCategory));

        groupedMap.forEach((k, v) -> System.out.println(k + " => " + v));
    }    
}