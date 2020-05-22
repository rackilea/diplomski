public interface MightHaveCompanion {
    public boolean hasCompanion();
}

public abstract class Visitor {
    // methods that all Visitors must have
}

public class Client extends Visitor implements MightHaveCompanion {
    // overriding implementations of MightHaveCompanion and Visitor methods 
}

public class Companion extends Visitor {
    // overriding implementations of Visitor methods
}