List <Users_Departments> userDeptList = new ArrayList<>();
for(int a=0 ; a < useridList.size();a++){   
    Users_Departments object = new Users_Departments();             
    object.setDepartment(departmentDao.find(deptId));
    object.setStation(userDao.find(useridList.get(a)));
    object.setCreatedDate(new Date());
    object.setUpdatedDate(new Date());

    Users_Departments newlyCreated = users_departmentsDao.create(object);
    userDeptList.add(newlyCreated);
}