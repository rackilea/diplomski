public class Test {
    public static void main(String[] args) throws Exception {   
        System.out.println(
            Test.class.getClassLoader().getResource("javax/servlet/http/HttpServlet.class"));
    }
}