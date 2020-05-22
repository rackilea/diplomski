class StrategyFactory {
    public static Strategy getStrategy(PersonType personType) {
        if(personType == STUDENT) return new StudentStrategy();
        if(personType == TEACHER) return new TeacherStrategy();
        return null;
    }
}