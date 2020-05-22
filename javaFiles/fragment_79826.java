fun doStuff() {
    val employeesObservable = employeeService.all()
    val wageProvider = Function<Employee, Single<Int>> { employee ->
        // Don't listen to changes. Take first wage and use that.
        employeeService.calculateWage(employee.id).firstOrError()
    }

    val employeesAndWagesObservable = 
            getEmployeesAndWagesObservable(employeesObservable, wageProvider)

    // Subscribe...
}