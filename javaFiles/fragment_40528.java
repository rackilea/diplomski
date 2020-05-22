JShell js = JShell.builder()
                 .compilerOptions("--module-path lib","--add-modules mysql.connector.java").build();
String code = ""
    + "try {"
    + "    Class.forName(\"com.mysql.jdbc.Driver\").newInstance();"
    + "} catch (Exception e) {"
    + "    System.out.println(e.toString());"
    + "}";
js.eval(code);