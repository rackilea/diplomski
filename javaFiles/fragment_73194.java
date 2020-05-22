public class CoordTest {

public static void main(String[] args) {
    System.out.println("Running tests...");

    System.out.println("Testing: equals");
    Coord c1a = new Coord(2,3);
    Coord c1b = new Coord(2,3);
    check(c1a.equals(c1b));

    System.out.println("Testing: not equals"); 
    Coord c2a = new Coord(2,3);
    Coord c2b = new Coord(6,8);
    Coord c2c = new Coord(2,8); 
    Coord c2d = new Coord(6,3);
    check(!c2a.equals(c2b));
    check(!c2a.equals(c2c));
    check(!c2a.equals(c2d));

    System.out.println("Testing: not found in empty stack"); 
    Stack<Coord> stack1 = new Stack<Coord>();
    int result1 = stack1.search(c1a);
    check(result1 == -1);

    System.out.println("Testing: not found in non-empty stack"); 
    Stack<Coord> stack2 = new Stack<Coord>();
    stack2.push(new Coord(4,5));
    stack2.push(new Coord(6,7));
    int result2 = stack2.search(c1a);
    check(result2 == -1);

    System.out.println("Testing: found in non-empty stack"); 
    Stack<Coord> stack3 = new Stack<Coord>();
    stack3.push(new Coord(4,5));
    stack3.push(new Coord(3,1));
    stack3.push(new Coord(6,7));        
    int result3 = stack3.search(new Coord(3,1));
    check(result3 == 2);        

    System.out.println("All tests completed successfully.");
}

private static void check(boolean condition) {
    if (!condition) {
        throw new RuntimeException("Condition failed!");
    }
}

}