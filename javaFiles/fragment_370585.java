class D implements B, C {
    @Override
    public void x() {
        B.super.x();       // Note explicit interface names
        C.super.x();
    }
}