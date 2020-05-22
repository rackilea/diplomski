public class MyClass {

    private Map<Class, Set> member;

    public <E> void putEnumSet(Class<E> elementType, Set<E> enumSet) {
        this.member.put(elementType, enumSet);
    }

    public <E> Set<E> getEnumSet(Class<E> elementType) {
        return (Set<E>) this.member.get(elementType));
    }
};