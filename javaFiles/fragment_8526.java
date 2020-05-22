String code = request.getParameter("code");
String className = "Code" + DigestUtils.sha1hex(code);
String classCode = ""
  + "public class " + className + " implements Runnable {\n" +
  + "  public void run() {\n" +
  + code + "\n"
  + "  }\n"
  + "}\n";
Files.write(new File(className + ".java"), code, StandardCharsets.UTF_8);

Runtime.getRuntime().exec("javac " + className + ".java");

Class<?> clazz = Class.forName(className);
((Runnable)clazz.newInstance()).run();