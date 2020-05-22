JShell js = JShell.create();
js.addToClasspath("path/to/add/to/the/classpath");
String code = ""
        + "try {"
        + "    Class.forName(\"com.mysql.jdbc.Driver\").newInstance();"
        + "} catch (Exception e) {"
        + "    System.out.println(e.toString());"
        + "}";
js.eval(code);