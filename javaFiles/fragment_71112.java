@Override
public String toString() {
    double com= staff1.displayCommission();
    double sala= staff1.displaySalary();
    double total= sala+com;

    return "Staff Name: " + staff1.displayName())
    + "\nStaff ID: " + staff1.displayStaffID())
    + "\nHours worked: " + staff1.displayworkingHours())
    + "\nTotal sales: RM" +staff1.displaySales())
    + "\nSalary: RM" + total );
}