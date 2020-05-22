enum A{
    A_FOO(1),
    A_BAR(2);
    private  int code;

    private A(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

enum B{
    B_FOO(1000,A_FOO),
    B_BAR(2000,A_BAR);

    private int code;
    private A status;

    private B(int code, A status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public A getStatus() {
        return status;
    }
}