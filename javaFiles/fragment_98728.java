students.sort(new Comparator<Student>() {
    @Override
    public int compare(final Student s1, final Student s2) {
        return s1.getPrizeMoney()-s2.getPrizeMoney();
    }
});

for (final Student student: students)
    System.out.println(student);