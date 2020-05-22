public Classes mapFromDTOCreate(ClassesCreateDTO classesCreateDTO){
    Classes classes = new Classes();
    classes.setSchool(schoolDAO.findSchoolById(classesCreateDTO.getSchoolId()));
    classes.setName(classesCreateDTO.getName());
    classes.setDateCreated(classesCreateDTO.getDateCreated());
    return classes;
}