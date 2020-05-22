public class ParseArray {
    public static void main(String[] args) throws IOException {
        String json = "[1, 2, 3]";
        int[] array = new ObjectMapper().readValue(json, int[].class);
        System.out.println("array = " + Arrays.toString(array));
    }
}