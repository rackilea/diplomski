public class ClasspathTest {

    public static void main(String args[]) throws URISyntaxException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");

        ClassPathResource testfile02 = new ClassPathResource("testfile02");

        if (testfile02 != null) {
            try (InputStream inputStream = testfile02.getInputStream();
                Reader streamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(streamReader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

    }

}