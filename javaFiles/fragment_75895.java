public int MaxIdenx() {
    int max = (Integer)session
        .createQuery("SELECT COALESCE(MAX(empId), 0) FROM Emp")
        .uniqueResult();

    return max + 1;
}