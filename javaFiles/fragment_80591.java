public List<String> getList() {                          // add <String>
    List<String> treq = new ArrayList<>();               // add <String> and <>
    List<String> deptList = new ArrayList<>();           // add <String> and <>
    try {
        treq = trDao.getList(status, dept, type, site);
        deptList = trDao.getDepts();
    }   
    catch (DAOException e) {
        setError(FORM_RESULTS, e.getMessage());
    }
    request.setAttribute("form", this);
    request.setAttribute("deptList", deptList);
    return treq;
}