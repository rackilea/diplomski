interface Website {
     void doSomething(Platform platform)
}

class Blog extends Website {

    public void doSomething(Platform platform) {
        platform.doTask(this);
    }
}

class Shop extends Website {

    public void doSomething(Platform platform) {
        platform.doTask(this);
    }    
}

class Platform {

    public doTask(Shop shop) {
       // Now you can work with shop variable
       shop.payCart();
    }

    public doTask(Blog blog) {
       // Now you can work with blog variable
       blog.postEntry("New blog entry");
    }

    void switchBetweenType(Website website) {
        // Instead of switch-case using polymorphism.
        website.doSomething(this);
    }
}