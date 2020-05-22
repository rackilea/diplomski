public class MyTestClass{
    public static void main(String[] args) {
        String row;
        String[] data = {};
        ObjectMapper objectMapper = new ObjectMapper();      

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("res/mydata.csv"));
            row = csvReader.readLine();
            data = row.split(",");

            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }       

        ArrayNode arrayNode = objectMapper.createArrayNode();

        ObjectNode personObjectNode = objectMapper.createObjectNode();
        personObjectNode.put("firstName", data[0]);
        personObjectNode.put("lastName", data[1]);
        arrayNode.add(personObjectNode);

        ArrayNode udaArrayNode = objectMapper.createArrayNode();
        ObjectNode approvalAuthorityObjectNode = objectMapper.createObjectNode();
        approvalAuthorityObjectNode.put("name", "UDF1");
        approvalAuthorityObjectNode.put("dataType", "number");
        approvalAuthorityObjectNode.put("entityCode", Integer.parseInt(data[15]));

        udaArrayNode.add(approvalAuthorityObjectNode);

        personObjectNode.putPOJO("udas", udaArrayNode);

        System.out.println(arrayNode.toString());    
    }
}