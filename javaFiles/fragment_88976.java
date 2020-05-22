class Test {
    public static void main(String[] args) {

        List<OBJ> objs = Arrays.asList(new Z(), new X());

        ObjVisitor toStringVisitor = new ObjVisitor() {
            public String visit(X x) { return "X object"; }
            public String visit(Y y) { return "Y object"; }
            public String visit(Z z) { return "Z object"; }
        };

        String result = "";
        for (OBJ o : objs)
            result += o.accept(toStringVisitor) + "\n";

        System.out.println(result);

        // Prints
        // Z object
        // X object
    }
}