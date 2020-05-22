public enum Flippable {
    A, B, Z, Y;

    static {
        A.opposite = Z;
        B.opposite = Y;
        Y.opposite = B;
        Z.opposite = A;
    }

    public Flippable flip() {
        return opposite;
    }

    private Flippable opposite;

    public static void main(String[] args) {         
        for(Flippable f : Flippable.values()) {
            System.out.println(f + " flips to " + f.flip());
        }
    }
}