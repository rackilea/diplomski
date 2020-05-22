Collectors.groupingBy(new Function<Student, String>() {
    @Override
    public String apply(Student student) {
        return student.getTeachersName();
    }
})