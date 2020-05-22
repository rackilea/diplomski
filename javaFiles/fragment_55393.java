static StringBuilder b1 = new StringBuilder();
static StringBuilder b2 = new StringBuilder();
...
static StringBuilder b10 = new StringBuilder();

public static void main(String[] args) {
    for (int i = 0; i < Math.pow(10, 8); i++)
        b1.append("a");
    System.out.println(b1.length());
    // ...
    for (int i = 0; i < Math.pow(10, 8); i++)
        b10.append("a");
    System.out.println(b10.length());
}