public class Edge {

    public Edge(In in) {
        String location = in.readString();
        System.out.println(location);
        for (int index = 0; index < 3; index++) {
            System.out.println(in.readInt());
        }
    }

}