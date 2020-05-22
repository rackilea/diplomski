public class A extends SomeName {
    protected void addSomeSpecialThings(final String value, final StringBuffer sb) {
        if (value.length() > 3){
            sb.append("D");
            sb.append("E");
        }
    }
}