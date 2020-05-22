public BaseTest {
    protected sharedVariable1;
    protected sharedVariable2;
    protected sharedVariable3;

    @Before
    public void sharedInit() {
        sharedVariable1 = //..
        sharedVariable2 = //..
        sharedVariable3 = //..
    }
}

public Test1 extends BaseTest {
    @Before
    public void specificInit() {
    }
}