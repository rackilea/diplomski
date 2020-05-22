@Override
public List<Category> getCategories() {
    // TODO Auto-generated method stub
    ProjectionList projectionList = Projections.projectionList();
    projectionList.add(Projections.property("id"), "id");
    projectionList.add(Projections.property("name"), "name");
    projectionList.add(Projections.property("date"), "date");
    return sessionFactory.getCurrentSession()
            .createCriteria(Category.class).setProjection(projectionList)
            .setResultTransformer(Transformers.aliasToBean(Category.class))
            .list();
}