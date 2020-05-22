public interface Resolver {
    void init();
}

Android implements Resolver {

    Android() {
        new AndroidApp(new LibGDX(this));
    }

    init() {
        // Code here
    }
}

IOS implements Resolver {

    IOS() {
        new IOSApp(new LibGDX(this));
    }

    init() {
        // Code here
    }
}

LibGDX {

    LibGDX(Resolver resolver) {

        resolver.init();
    }
}