public int m2(boolean b) {
    try {
        throw b ? new Excep1() : new Excep2();
    } catch (Exception e) {
        return 0;
    }
}