public String loadQuery(String fileName) {
  final String newline = "\n";

  ApplicationContext ctx = new ClassPathXmlApplicationContext();
  Resource res = ctx.getResource("classpath:/com/msi/queries/" + fileName);
  BufferedReader reader;
  StringBuilder sb = new StringBuilder();
  try {
     reader = new BufferedReader(new InputStreamReader(res.getInputStream()));
     String line;

     while ((line = reader.readLine()) != null) {
        sb.append(line);
        sb.append(newline);
     }
  } catch (IOException e) {
     LOGGER.error(e);
  }

  return sb.toString();