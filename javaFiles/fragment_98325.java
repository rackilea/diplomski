public abstract class User {
    public void clearAgenda() {} // do nothing (or or something if you want)
}

public class UserA extends User {
    @Override public void clearAgenda() { ... } // do stuff specific to A
}

public class UserB extends User {
    @Override public void clearAgenda() { ... } // do stuff specific to B
}

public class UserC extends User {
}

public class System {
    private User loggedUser;

    public void clearUserAgenda() {
        // This will use the most appropriate method. If the type is
        // UserA, UserA's `clearAgenda` method will be used. Similar
        // for UserB. For UserC, The abstract User class's `clearAgenda`
        // method is used, because it was not overridden in UserC.
        loggedUser.clearAgenda();
    }
}