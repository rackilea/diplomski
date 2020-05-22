public boolean addEmployee(String fName, String lName, Position p) {
    //since this method will be in the Company class, we can directly
    //refer to the number of a specific position type
    //I'm going to assume you know how a switch statement works.
    switch (p) {
        case SALES:
            //if there's less than 1 salesman, add them to the list
            if (numOfSalesmen < 1) {
                Employee employee = new Employee(fName, lName, p);
                //assuming you name your ArrayList<Employee> 'staffList'
                staffList.add(employee);
            }
            else {
                //give some error message or some functionality with GUI
            }
            break;

        case DESIGN:
            if (numOfDesigners < 2) {
                ...
            }
            break;

        ...

        default:
            //some error handling
            break;
    }
}