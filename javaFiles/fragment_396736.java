@Override
@SuppressWarnings("unchecked")
public List<Employee> listEmployees() {
    return this.session.createCriteria(Employee.class).
    setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
}