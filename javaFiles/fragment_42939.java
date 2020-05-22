PropsDemo demo = new PropsDemo();
String prop1 = "config1.properties";
String prop2 = "config2.properties";

Properties props = new Properties();
InputStream input1 = demo.getClass().getClassLoader().getResourceAsStream(prop1);
InputStream input2 = demo.getClass().getClassLoader().getResourceAsStream(prop2);
try
{
    props.load(input1);
    props.load(input2);
    System.out.println(props.toString());
}
catch (IOException e)
{
    System.out.println("Something went wrong!");
}