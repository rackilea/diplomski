final GroovyClassLoader classLoader = new GroovyClassLoader();
Class groovy = classLoader.parseClass(new File("script.groovy"));
GroovyObject groovyObj = (GroovyObject) groovy.newInstance();

ByteArrayOutputStream buffer = new ByteArrayOutputStream() ;
PrintStream saveSystemOut = System.out ;
System.setOut( new PrintStream( buffer ) ) ;

groovyObj.invokeMethod("main", null);

System.setOut( saveSystemOut ) ; 
String output = buffer.toString().trim() ;