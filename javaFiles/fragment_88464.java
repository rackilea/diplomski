public class Test {  
    public static void main(String[] args) throws IOException {
        String[] arr = {"John 19 California", 
                        "Justin 20 LA", 
                        "Helena 10 NY"};
        Path p = Files.write(new File("content.txt").toPath(), 
                             Arrays.asList(arr),
                             StandardCharsets.UTF_8);
        System.out.println("Wrote content to "+p);
    }   
}