if( attendancePolicy.getType().equals( AttendanceConstants.EMPLOYEE_ATTENDANCE_POLICY ) ) {
    synchronized( attendancePolicy.getListEmployee() ) {

        // Explicitly create the Iterator and loop condition
        for( Iterator<EmployeeAttendancePolicy> it = 
attendancePolicy.getListEmployee().iterator(); it.hasNext(); ) {

            // Explicitly declare the looping variable
            EmployeeAttendancePolicy employeeAttendancePolicy = it.next(); 

            employeeInfo = employeeInfoSessionBeanLocal.findEmployeeInfoEntityByEmployeeInfoId( 
                    employeeAttendancePolicy.getEmployeeId() );

            if( employeeInfo != null ) {
                employeeAttendancePolicy.setEmpName( 
                        employeeInfo.getFirstName() + " " 
                        + employeeInfo.getMiddleName() + " "
                        + employeeInfo.getLastName() );

                company = companySessionBeanLocal.findCompanyById( employeeInfo.getCompanyId() );
                employeeAttendancePolicy.setCompanyName( company.getName() );

                department = departmentSessionBeanLocal.findDepartmentEntityByDepartmentId( 
                        employeeInfo.getDepartmentId() );
                employeeAttendancePolicy.setDepartmentName( department.getName() );
            }
            else {

                // Use the Iterator's remove method to safely remove
                // thus avoiding the ConcurrentModificationException
                it.remove();

            }
        }
    }
}