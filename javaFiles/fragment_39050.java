public class BasePage {
    public Locomotive test;
    public BasePage(Locomotive baseTest) {
        test = baseTest;
    }
}

public class test_a_Home extends BasePage {
    public test_a_Home(Locomotive baseTest) {
        super(baseTest);
    }

    public void testifExists() {
        test.validatePresent(site_a_Home.EL_NEWCUSTOMERBANNER);
    }
}