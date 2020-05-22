List<String> coaches = new ArrayList<>();
coaches.add("Josh");
coaches.add("Jake");
coaches.add("Tyler");

List<String> teachers = new ArrayList<>();
teachers.add("Josh");
teachers.add("Jake");

List<String> CoachesNotAlsoTeachers = new ArrayList<>();
CoachesNotAlsoTeachers.add(coaches);
CoachesNotAlsoTeachers.removeAll(teachers);

for (String name : CoachesNotAlsoTeachers ) {
    System.out.println("Name is: " + name);
}