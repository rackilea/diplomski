private volatile static Instance instance;

public static Instance getInstance() {
    if (this.instance == null) {
        this.instance = new Instance();
    }
    return this.instance;
}