public static void main(String[] args) throws Exception {
    String line;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

    while (!"fin".equals(line = reader.readLine())) {
        System.out.println(line);
    }

    System.out.println("buy");
}