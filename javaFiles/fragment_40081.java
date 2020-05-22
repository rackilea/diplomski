List<Course> courses = new ArrayList<>();
try (BufferedReader br = Files.newBufferedReader(Paths.get("testC.txt"))) {
    String line;
    Course course = new Course();
    while ((line = br.readLine()) != null) {
        if (!line.trim().isEmpty()) {
            if (course.getCrn() == null) {
                course.setCrn(line.trim());
            } else if (course.getName() == null) {
                course.setName(line.trim());
            } else if (course.getDescription() == null) {
                course.setDescription(line.trim());
            } else {
                course.setCredit(line.trim());
                courses.add(course);
            }
        } else {
            course = new Course();
        }
    }
} catch (IOException e) {
    //TODO exception handling
}