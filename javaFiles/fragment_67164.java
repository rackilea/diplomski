class Z extends Y {
    public Z() {
        v += 9;
    }

    public void proc(Z p) {
        someActions();
        System.out.println(39);
    }

    private void someActions() {
        System.out.println("Some actions");
    }

}