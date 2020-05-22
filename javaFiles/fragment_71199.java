@Override
public int hashCode() {
       firstName = firstName != null ? firstName.toLowerCase() : firstName;
       lastName = lastName != null ? lastName.toLowerCase() : lastName;
       return Objects.hash(firstName, lastName);
}