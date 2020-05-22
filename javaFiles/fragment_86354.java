for (Employee employee : listEmployee) {
    for (String departmentName : employee.getDepartment()) {
        DepartmentStats departmentStats = departmentStatsMap.get(departmentName);
        if (departmentStats == null) departmentStats = new DepartmentStats(departmentName);
        departmentStats.total++;
        if (employee.getStatus().equals("active")) departmentStats.activeCount++;
        if (employee.getStatus().equals("inactive")) departmentStats.inactiveCount++;
        departmentStatsMap.put(departmentName, departmentStats);
    }
}