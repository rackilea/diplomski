public void saveEmployee(Employee empl){
    try {
        jdbcTemplate.update("INSERT INTO EMP VALUES(?,?,?,?,?)",empl.getEmpId(),empl.getEmpName(),
                empl.getDeptId(),empl.getAge(),empl.getSex());
    } catch (DataAccessException e) {
        e.printStackTrace();
        throw e;
    }

}