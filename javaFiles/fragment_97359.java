public class MyClass {
    public static void main(String args[]) {
        String s = "Name:1/1, Network: true, ...(more data)... MPEG: true Multiplex: 0004, Transport Stream ID: 0, Bandwidth: 5000000,...(more data)... Reserved Bandwidth: 1000 Multiplex: 0002, Transport Stream ID: 0, Bandwidth: 5000000,...(more data).. Reserved Bandwidth: 200 Multiplex: 0008, Transport Stream ID: 0, Bandwidth: 5000000, Reserved Bandwidth: 100000,...(more data)...true";
        String[] arr = s.split("(?=Multiplex:)");

        for(String str : arr){
            System.out.println(str);
        }
    }
}