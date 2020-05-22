while(rs.next())
{
        departmentId = rs.getInt(1);
        departmentTypeList = rs.getString(2);

        DepartmentList dep = new DepartmentList(departmentId,departmentTypeList); //Create a department
       cbDepartmentType.addItem(dep ); //insert into the combo
}