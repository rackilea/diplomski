public class TestNetwork {
    public static void main(String[] args){
        Network network = new Network("file.txt");  <-- create instance
        ArrayList<String> nodes = network.nodes;    <-- reference the data
        ArrayList<String> edges = network.edges;

        for (String s : nodes) {                    <-- traverse data
            System.out.println(s);                  <-- print data
        }

        for (String s : edges){
            System.out.println(s);
        }
    }
}