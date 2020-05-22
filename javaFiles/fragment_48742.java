public Shared {
    private sharedVariable1;
    private sharedVariable2;
    private sharedVariable3;

    public Shared() {
        sharedVariable1 = //..
        sharedVariable2 = //..
        sharedVariable3 = //..
    }
}

public Test1 {
    private Shared shared;

    @Before
    public void init() {
        shared = new Shared();
    }
}