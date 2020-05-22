class Y {}

class X extends Y implements Cloneable {
    @Override
    public X clone() {
        try {
            return (X) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        } 
    }
}