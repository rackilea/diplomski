catch (DataAccessException e) {
    System.out.println(e.sqlStateClass());
    System.out.println(e.sqlStateSubclass());

    if (SQLStateSubclass.C40001_SERIALIZATION_FAILURE == e.sqlStateSubclass()) {
        ...
    }
}