public class PhoneNumber implements Comparable<PhoneNumber> {

    private final Phone type;
    private final String number;

    public PhoneNumber(final Phone type, final String number) {
        this.type = type;
        this.number = number;
    }

    public Phone getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    /**
     * Sort by type, then number
     */
    @Override
    public int compareTo(final PhoneNumber other) {
        int typeComparison = getType().compareTo(other.getType());
        return typeComparison == 0 ? getNumber().compareTo(other.getNumber()) : typeComparison;
    }

    @Override
    public String toString() {
        return getType() + ":" + getNumber();
    }

}