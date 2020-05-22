interface UserPageUtils{
       public Webdriver getDriver();
       default void makeUsersLifeMiserable(){
            //somewhere here you use getDriver();
       }
    }

    interface ActionPageUtils{
       public Webdriver getDriver();
       default void doSomethingCoolWithAction() {
           //somewhere here you use getDriver();
       }
    }

    class PageUtils implements UserPageUtils, ActionPageUtils {
        private final Webdriver driver;

        @Override
        public Webdriver getDriver() {
            return driver;
        }
    }