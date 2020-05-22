StringBuilder departments = new StringBuilder();
//prints a list of all employees in the system for user to choose from
for (int i = 0; i < allDepartments.size(); i++) {
    departments.append("Department no: ");
    departments.append(i + 1);
    departments.append(" Department name: ");
    departments.append("<departmentDetails>");
    departments.append(" Location: ");
    departments.append(allDepartments.get(i));
    departments.append('\n');
}
System.out.println(departments.toString());