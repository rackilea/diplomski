public class NumbersType
implements Numbers {
    private int intType;

    public NumbersType(int intType) {
        this.intType = intType;
    }

    @Override
    public int getIntType() {
        return intType;
    }

    @Override
    public boolean isIntTypeEqual(Number n) {
        return intType == n.getIntType();
    }

    // overriding hashCode because we are overriding equals
    @Override
    public int hashCode() {
        return intType;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Numbers))
            return false;

        return isIntTypeEqual((Numbers)o);
    }
}