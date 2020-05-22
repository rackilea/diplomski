public class Example {

    public Example() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Example)) {
            return false;
        }
        Example other = (Example) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$firstName = getFirstName();
        Object other$firstName = other.getFirstName();
        if (this$firstName != null ? !this$firstName.equals(other$firstName) : other$firstName != null) {
            return false;
        }
        Object this$lastName = getLastName();
        Object other$lastName = other.getLastName();
        return this$lastName != null ? this$lastName.equals(other$lastName) : other$lastName == null;
    }

    public boolean canEqual(Object other) {
        return other instanceof Example;
    }

    public int hashCode() {
        int PRIME = 31;
        int result = 1;
        Object $firstName = getFirstName();
        result = result * 31 + ($firstName != null ? $firstName.hashCode() : 0);
        Object $lastName = getLastName();
        result = result * 31 + ($lastName != null ? $lastName.hashCode() : 0);
        return result;
    }

    public String toString() {
        return (new StringBuilder()).append("Example(firstName=").append(getFirstName()).append(", lastName=").append(getLastName()).append(")").toString();
    }
    private String firstName;
    private String lastName;
}