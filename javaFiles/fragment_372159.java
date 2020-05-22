@Test
public void test() {
    Integer i=100, j=200;
    System.out.println("i: " + System.identityHashCode(i));
    System.out.println("j: " + System.identityHashCode(j));

    Integer sub = j-i;
    System.out.println("j-i: " + System.identityHashCode(sub));
}