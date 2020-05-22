public void print_f(IntFunction f) {
    IntStream.range(0, this.N).forEach(i->System.out.println(f.apply(i)));
}

public static void main (String[] args) {
    int n = 10;
    if (args.length == 1)
        n = Integer.parseInt(args[0]);
    Testing t = new Testing (n);
    t.print_f(Testing::f);
}