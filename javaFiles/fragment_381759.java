public ClassesDTO mapToDTO(Classes classes) {
    ClassesDTO classesDTO = new ClassesDTO();
    classesDTO.setId(classes.getId());
    classesDTO.setSchoolId(classes.getSchool().getId());
    classesDTO.setSchoolName(classes.getSchool().getName());
    // etc...