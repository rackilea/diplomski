import org.apache.commons.lang.builder.*;

public class CustomType implements Comparable<CustomType> {
    // constructors, etc
    // let's say that the "significant" fields are field1, field2, field3
    @Override public String toString() {
        return new ToStringBuilder(this)
            .append("field1", field1)
            .append("field2", field2)
            .append("field3", field3)
                .toString();
    }
    @Override public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof CustomType)) { return false; }
        CustomType other = (CustomType) o;
        return new EqualsBuilder()
            .append(this.field1, other.field1)
            .append(this.field2, other.field2)
            .append(this.field3, other.field3)
                .isEquals();
    }
    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(field1)
            .append(field2)
            .append(field3)
                .toHashCode();
    }
    @Override public int compareTo(CustomType other) {
        return new CompareToBuilder()
            .append(this.field1, other.field1)
            .append(this.field2, other.field2)
            .append(this.field3, other.field3)
                .toComparison();
    }
}