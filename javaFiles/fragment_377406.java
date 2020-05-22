final int courseCode = Integer.valueOf(courseId.getText());
Task<Course> courseTask = new Task<Course>() {
    @Override
    public Course call() throws Exception {
        return myDAO.getCourseByCode(courseCode);
    }
};
courseTask.setOnSucceeded(e -> {
    Course course = courseTask.getCourse();
    if (course != null) {
        courseCodeLbl.setText(course.getName());
    }
});
exec.execute(courseTask);