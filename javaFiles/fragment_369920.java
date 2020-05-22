class UserPageUtils{
    private final Webdriver driver;

    public UserPageUtils(driver){
        this.driver = driver;
    }

    public void makeUsersLifeMiserable(){...}
}

class ActionPageUtils{
    private final Webdriver driver;

    public ActionPageUtils(driver){
        this.driver = driver
    }

    public void doSomethingCoolWithAction(){...}
}

class PageUtils{
    private final Webdriver driver;
    private final ActionPageUtils action;
    private final UserPageUtils user;

    public void doSomethingCoolWithAction(){action.doSomethingCoolWithAction();}
    public void makeUsersLifeMiserable(){user.makeUsersLifeMiserable();}
}