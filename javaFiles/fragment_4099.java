private List<Employee> mEmployees = new ArrayList<Employee>()

/** 
 * Removes one employee from the corporation
 */
public void remove(Employee employee) {
    mEmployees.remove(employee);
}

/**
 * Inserts a new employee
 */
public void insert(Employee employee) {
    // can check for unicity (optional):
    if (mEmployees.contains(employee)) throw new IllegalArgumentException("Employee already exists");

    mEmployees.add(employee);
}