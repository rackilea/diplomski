public class generateServerIP {
    public static void main(String args[]){
        ArrayList<String> al = new ArrayList<>();
        al.add("172.62.22.103");
        al.add("172.62.22.123");
        al.add("172.62.22.15");
        al.add("172.62.22.187");
        al.add("172.62.22.110");

        int ip = new Random().nextInt(al.size());
        System.out.println(al.get(ip));
    }  
}