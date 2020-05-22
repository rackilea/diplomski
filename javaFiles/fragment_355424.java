@Override
public int compareTo(Person t) {
    final int personComparisonResult = super.compareTo(t);

    if (personComparisonResult == 0) {
        return program.compareTo(((Student) t).program);
    }

    return personComparisonResult;
}