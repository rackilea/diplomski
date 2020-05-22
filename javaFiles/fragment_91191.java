class FirstListener implements ApplicationListener<Foo>, Ordered {
    public int getOrder() {
        return 10;
    }
    //...
}

class SecondListener implements ApplicationListener<Foo>, Ordered {
    public int getOrder() {
        return 20;
    }
    //...
}

class LastListener implements ApplicationListener<Foo>, Ordered {
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
    //...
}