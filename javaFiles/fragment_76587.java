public class TriangleNumGenerator {
    int counter;
    int sides;

    public TriangleNumGenerator(){
        sides = 1;
        counter = 2;  // forgot ; here**

    }
    public int nextTri(){
        sides = sides+counter;
        counter = counter+1;
        return sides;

    }

    public void reset(){
        counter = 2;
        sides = 1;
    }

    // you forgot main method; it has to be exactly same so that JVM 
    // can find it
    public static void main(String[] args) {
        TriangleNumGenerator ne = new TriangleNumGenerator();
        System.out.println(ne.nextTri());  // forgot () in nextTri
    }
}