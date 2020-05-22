@Override
public int compareTo(Student other) {
    int result = l.compareTo(other.getLastName());
    if (result == 0) {
        return f.compareTo(other.getFirstName());
    } else {
        return result;
    }
}