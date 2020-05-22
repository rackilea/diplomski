public class Demo {   
    public static void main(String[] args) {
        String str=";;7.52;;;;;;2.89;3.05;2.48;";
        while(str.contains(";;"))
            str=str.replaceAll(";;", ";0;");            
        System.out.println(str);
    }
}