interface UserPageUtils{
    public void makeUsersLifeMiserable();
}

interface ActionPageUtils{
    public void doSomethingCoolWithAction();
}

class PageUtils implements UserPageUtils, ActionPageUtils {
   //concrete implementations
}