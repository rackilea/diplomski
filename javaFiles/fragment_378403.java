class Base {
    private String ultimateProperty;

    Base() {
    }

    Base(String ultimateProperty) {
        this.ultimateProperty = ultimateProperty;
    }

    public void setUltimateProperty(String ultimateProperty) {
        this.ultimateProperty = ultimateProperty;
    }
}

class Hi extends Base {
    @Value("Hi")
    public void setUltimateProperty(String ultimateProperty) {
        super.setUltimateProperty(ultimateProperty);
    }
}

class Bye extends Base {
    public Bye(@Value("Bye") String ultimateProperty) {
        setUltimateProperty(ultimateProperty);
    }
}

class Later extends Base {
    public Later(@Value("Later") String ultimateProperty) {
        super(ultimateProperty);
    }
}

class AndAgain extends Base {
    @Value("AndAgain")
    private String notQuiteUltimate;

    @PostConstruct
    public void doStuff() {
        super.setUltimateProperty(notQuiteUltimate);
    }
}