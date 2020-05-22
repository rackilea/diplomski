public class ClassesPair {
    public final Class<? extends AbstractObject> targetClass;
    public final Class<? extends AbstractObject> objectClass;

    public ClassesPair(Class<? extends AbstractObject> targetClass, Class<? extends AbstractObject> objectClass) {
        this.targetClass = targetClass;
        this.objectClass = objectClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassesPair that = (ClassesPair) o;

        if (!targetClass.equals(that.targetClass)) return false;
        return objectClass.equals(that.objectClass);
    }

    @Override
    public int hashCode() {
        int result = targetClass.hashCode();
        result = 31 * result + objectClass.hashCode();
        return result;
    }
}

public interface CollisionHandler<T extends AbstractObject, O extends AbstractObject> {
    void handleCollision(T target, O object);
}

public class CollisionsDispatcher {
    private final Map<ClassesPair, CollisionHandler> originalDispatchMap = new HashMap<>();
    private Map<ClassesPair, CollisionHandler> extendedDispatchMap = new HashMap<>();

    private CollisionHandler getHandlerOrParent(Class<? extends AbstractObject> targetClass, Class<? extends AbstractObject> objectClass) {
        //Need to decide on the rules, for now target is more important
        Class stopClass = AbstractObject.class.getSuperclass();
        for (Class tmpTarget = targetClass; tmpTarget != stopClass; tmpTarget = tmpTarget.getSuperclass()) {
            for (Class tmpObject = objectClass; tmpObject != stopClass; tmpObject = tmpObject.getSuperclass()) {
                CollisionHandler collisionHandler = originalDispatchMap.get(new ClassesPair(tmpTarget, tmpObject));
                if (collisionHandler != null)
                    return collisionHandler;
            }
        }
        return null;
    }

    public CollisionHandler getHandler(Class<? extends AbstractObject> targetClass, Class<? extends AbstractObject> objectClass) {
        ClassesPair key = new ClassesPair(targetClass, objectClass);
        CollisionHandler collisionHandler = extendedDispatchMap.get(key);
        if (collisionHandler == null) {

            // choice #1
            // Just fail every time nothing was found
            //throw new UnsupportedOperationException("Collision of " + targetClass.getName() + " with " + objectClass.getName() + "' is not supported");

            // choice #2 go through handlers for parents.
            // It provides ability to put some generic logic only once
            // Need to decide on the rules, for now target is more important
            collisionHandler = getHandlerOrParent(targetClass, objectClass);
            if (collisionHandler != null) {
                extendedDispatchMap.put(key, collisionHandler); // put it back for faster future usages
            } else {
                throw new UnsupportedOperationException("Collision of " + targetClass.getName() + " with " + objectClass.getName() + "' is not supported");
            }

            // choice #3
            // Just do nothing. Everything that has no explicit handler is not affected by collision
            // return null;
        }
        return collisionHandler; // God save Java with its type erasure for generics!
    }

    public void handleCollision(AbstractObject target, AbstractObject object) {
        CollisionHandler handler = getHandler(target.getClass(), object.getClass());
        if (handler != null) { // this check only for choice #3
            handler.handleCollision(target, object); // God save Java with its type erasure for generics!
        }
    }

    public <T extends AbstractObject, O extends AbstractObject> void registerHandler(Class<T> targetClass, Class<O> objectClass, CollisionHandler<? super T, ? super O> handler) {
        ClassesPair key = new ClassesPair(targetClass, objectClass);
        originalDispatchMap.put(key, handler);
        // just clear extended cache. It is much easier than to track all possible propagated values
        // and handle them properly. On the other hand registerHandler should be called only a few
        // time during set up so it shouldn't be real penalty in performance
        extendedDispatchMap = new HashMap<>();
    }
}