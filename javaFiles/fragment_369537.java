// A visitor, which can 'visit' all your types
interface CustomObjectVisitor {
    void visitA(CustomObjectA a);
    void visitB(CustomObjectB b);
}

// Make CustomObject a visitee
public interface CustomObject {
    void accept(CustomObjectVisitor visitor);
}

// Implement the classes with the accept method
public class CustomObjectA implements CustomObject {
    @Override public void accept(CustomObjectVisitor visitor) {
        visitor.visitA(this);
    }
}
public class CustomObjectB implements CustomObject {
    @Override public void accept(CustomObjectVisitor visitor) {
        visitor.visitB(this);
    }
}