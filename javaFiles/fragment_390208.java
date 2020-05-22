class GroupedPersons {

    private String dept;
    private int sumAmount;
    private List<Person> personsOfDept;

    public GroupedPersons(String dept, int sumAmount, List<Person> personsOfDept) {
        this.dept = dept;
        this.sumAmount = sumAmount;
        this.personsOfDept = personsOfDept;
    }
}