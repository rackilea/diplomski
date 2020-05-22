public static void main(String[] args){ 

    Function<String,String> trimUrlString = s -> { 
        s = s.endsWith("/") ? s.substring(0, s.length()-1) : s;
        return  s.substring(0, s.lastIndexOf('/')+1);
    };

    String u1 = "localhost:8080/myapp";        
    System.out.println(trimUrlString.apply(u1));
    String u2 = "https://myapp-dev.myhost.com/app/";     
    System.out.println(trimUrlString.apply(u2));        
}
//output: localhost:8080/      https://myapp-dev.myhost.com/