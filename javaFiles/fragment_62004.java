public class Person {
    List<Person> children;
    ObjectIS myIncomeStatement;
    ObjectIS familyIncomeStatement;

    public ObjectIS getFamilyIncomeStatement() {
        ObjectIS is = new ObjectIS();
        for(Person p: children) {
            is.income += p.familyIncomeStatement.income;
        }
        is.income += this.myIncomeStatement.income;
        return is;
    }
}

// sample objectIS class
public class ObjectIS {
    private int income;
}