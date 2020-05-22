public abstract class SomeName {
    public final String createString(final String value){
        if (value ==  null){
            throw new NullPointerException("value must NOT be null.");
        }
        final StringBuffer sb = new StringBuffer();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        addSomeSpecialThings(value, sb);
        sb.append("Z");
        return sb.toString();   
    }

    protected abstract void addSomeSpecialThings(final String value,
            final StringBuffer sb);
}