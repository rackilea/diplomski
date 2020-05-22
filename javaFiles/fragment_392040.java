class DBAdapter<T extends DBObject> {
    List<T> fetchAll() {
        ...
    }
}

class DBCategoryAdapter extends DBAdapter<Category> {

}