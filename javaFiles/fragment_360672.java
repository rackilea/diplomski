public abstract class LazyUserDataModel extends LazyDataModel<User> {

    @Override
    public List<User> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map filters) {
        List<User> users;
        users = findAllUsers();
        this.setRowCount(users.size());
        return users ; 
    }

    public abstract List<User> findAllUsers();

}