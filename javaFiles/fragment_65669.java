public void example(int i, Object o) {}

public static void main(String[] args) {

    Object o = new Object();

    example(3, o);//This is passing the number 3 to the function. It also passes by vlue a pointer to where object o is stored in memory.
}