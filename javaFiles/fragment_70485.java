private String config1;
private String config2;

public Parent() {
this.instance = getInstance();
}

private Parent(String config1, String config2) {
this.config1 = config1;
this.config2 = config2;

}

private static Parent instance = null;

public static Parent getInstance() {
if (instance == null) {
    synchronized (Parent.class) {
    if (instance == null) {
        instance = new Parent("SingleTonConfig1", "SingleTonConfig2");
    }
    }
}
return instance;
}

public String getConfig1() {
return config1;
}

public void setConfig1(String config1) {
this.config1 = config1;
}

public String getConfig2() {
return config2;
}

public void setConfig2(String config2) {
this.config2 = config2;
}