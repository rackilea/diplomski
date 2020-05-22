public static void main(String[] args) {

    JSONParser parser = new JSONParser();

    try {
        Object obj = parser.parse(new FileReader("data.json"));

        JSONArray jsonObjects =  (JSONArray) obj;

        for (Object o : jsonObjects) {
            JSONObject jsonObject = (JSONObject) o;
            String name = (String) jsonObject.get("name");
            System.out.println(name);

            Long totalSales = (Long)jsonObject.get("totalSales");
            System.out.println(totalSales);

            String salesPeriod = (String) jsonObject.get("salesPeriod");
            System.out.println(salesPeriod);

            String exp = (String) jsonObject.get("exp");
            System.out.println(exp);
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }
}