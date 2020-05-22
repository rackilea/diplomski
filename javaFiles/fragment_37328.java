public class MoreProblem {

    public static void main(String[] args) {
        Icosahedron[] icos = new Icosahedron[4];
        for (int i = 0; i < icos.length; i++) {
            icos[i] = new Icosahedron(i+1);
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Edge Length: ");
            double userEdge = input.nextDouble();
            icos[i].setEdge(userEdge);
        }

        for (Icosahedron icosahedron : icos) {
            System.out.println(icosahedron);
        }

        System.out.println("Number of Icosahedron objects created: " + icos.length);
    }

}