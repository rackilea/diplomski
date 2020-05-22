private Teacher getTeacherForCourse(List<Teacher> teachers, long id) {
    for(Teacher teacher : teachers)
    {
        // Return the teacher if match the criteria
        if(teacher.getId() == id)
        {
            return teacher;
        }
    }
    return null; // or throw exception
}