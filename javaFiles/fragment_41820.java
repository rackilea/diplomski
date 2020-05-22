class read$ {
    static read$ MODULE$

    static {
        new read$()
    }

    private Par[Int] res5;

    private read$() {
        MODULE$ = this;
        res5 = Par.fork(read$::aWrapper)(es).get
    }

    private static int aWrapper(){
        return line3.read$.MODULE$.a;
    }
}