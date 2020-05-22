public void create(Course entity) {
    super.create(entity);
}

public void edit(@PathParam("id") Integer id, Course entity) {
    super.edit(entity);
}