public class Host {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(Method.POST);
        System.out.println(Method.POST);
        System.out.println(Method.POST);
    }

    Host()
    {
        System.out.println("--------------");
    }

    String getAssets()
    {
        System.out.println("ssssssssssss");
        return "eeee";
    }
}


enum Method {
    POST(new Host().getAssets()),
    GET("GET"),
    DELETE("DELETE"),
    PUT("PUT");

    private String method;

    Method(String s) {
        method = s;
    }

    private String getMethod() {
        return method;
    }
}