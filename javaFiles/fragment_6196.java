@Setter
@Inject
private IGenericDAO<Employee> dao;

@Override
public void save(Employee Employee) {
    dao.save(Employee);
}

@Override
public void update(Employee Employee) {
    dao.update(Employee);
}

@Override
public Employee getObjectById(int id) {
    return dao.getObjectById(id);
}

@Override
public List<Employee> getAll() {
    return dao.getAll();
}}