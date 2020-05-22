class DataAcess {
    private Map<Integer, Person> persList;
    private Map<String, List<Person>> personsByDebt;
    public DataAcess(Map persList) {
        this.persList = persList;
        this.personsByDebt=this.persList.values().stream()
                .filter(person-> Objects.nonNull(person.dept))
                .collect(Collectors.groupingBy(person-> person.dept.id));
    }

    public List<Person> getPersByDept(String dept) {
        return personsByDebt.getOrDefault(dept, Collections.emptyList());
    }
}