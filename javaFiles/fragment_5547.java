interface Website {
     void doSomething(Platform platform)
}

class Blog extends Website {

    public void doSomething(Platform platform) {
        platform.doBlogTask();
    }
}

class Shop extends Website {

    public void doSomething(Platform platform) {
        platform.doShopTask();
    }    
}

class Platform {

    public doShopTask() {
       // Put specific logic here
    }

    public doBlogTask() {
       // Put specific logic here
    }

    void switchBetweenType(Website website) {
        // Instead of switch-case using polymorphism.
        website.doSomething(this);
    }
}