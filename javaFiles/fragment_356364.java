private List<DepartmentInfo> retrieveLinkedDepartments(final Collection<Section> sections) {
    return this.departmentDao
               .findAll()
               .stream()
               .filter(department -> department.getSectionId() != null)
               .filter(department -> sections.stream()
                                 .mapToLong(Section::getId)                                     
                                 .anyMatch(department.getSectionId()::equals))                                           
               .map(this.departmentInfoMapper::map)
               .collect(Collectors.toList());
}