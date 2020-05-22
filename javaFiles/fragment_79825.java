/**
 * @param employeesObservable
 * Stream of employees we're interested in.
 * @param wageProvider
 * Transformation function which takes an employee and returns a [Single] of their wage.
 * @return
 * Observable stream spitting individual [Pair]s of employees and their wages.
 */
fun getEmployeesAndWagesObservable(
        employeesObservable: Observable<Employee>,
        wageProvider: Function<Employee, Single<Int>>
): Observable<Pair<Employee, Int>>? {
    val employeesAndWagesObservable: Observable<Pair<Employee, Int>>

    // Each Employee from the original stream will be converted
    // to a Single<Pair<Employee, Int>> via flatMapSingle operator.
    // Remember, we need a stream and Single is a stream.
    employeesAndWagesObservable = employeesObservable.flatMapSingle { employee ->
        // We need to get a source of wage value for current employee.
        // That source emits a single Int or errors.
        val wageForEmployeeSingle: Single<Int> = wageProvider.apply(employee)

        // Once the wage from said source is loaded...
        val employeeAndWageSingle: Single<Pair<Employee, Int> = wageForEmployeeSingle.map { wage ->
            // ... construct a Pair<Employee, Int>
            employee to wage
        }

        // This code is not executed now. It will be executed for each Employee
        // after the original Observable<Employee> starts spitting out items.
        // After subscribing to the resulting observable.
        return@flatMapSingle employeeAndWageSingle
    }

    return employeesAndWagesObservable
}