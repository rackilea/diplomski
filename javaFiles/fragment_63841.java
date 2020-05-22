final AtomicMarkableReference<Boolean> twoBooleans = (
    new AtomicMarkableReference<Boolean>(true, false)
);

void somewhere() {
    boolean b0;
    boolean[] b1 = new boolean[1];
    b0 = twoBooleans.get(b1);

    b0 = false;
    b1[0] = true;

    twoBooleans.set(b0, b1);
}