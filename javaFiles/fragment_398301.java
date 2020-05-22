@Transactional(propagation=Propagation.REQUIRES_NEW)
public void saveEmployee(Employee empl){
    try {
        jdbcTemplate.update("INSERT INTO EMP VALUES(?,?,?,?,?)",empl.getEmpId(),empl.getEmpName(),
                empl.getDeptId(),empl.getAge(),empl.getSex());
    } catch (DataAccessException e) {
        e.printStackTrace();
        throw e;
    }

}

@Transactional(propagation=Propagation.REQUIRED)
public void saveRecords(){
    saveDepartment(dept);
    try{
       saveEmployee(empl);
    }catch(Exception e){Logger.log("Fail to save emp !");}     
}