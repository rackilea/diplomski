public class App 
{
    public static void main(String[] args) throws JsonProcessingException {

        int[][][] a = new int[2][3][2];
        a[0][2][0] = 3;

        ObjectMapper om = new ObjectMapper();

        // Serialize to JSON
        String json = om.writeValueAsString(a);
        System.out.println(json);

        // deserialize back from JSON
        a = om.readValue(json, int[][][].class);
        System.out.println(a[0][2][0]);

   }
}