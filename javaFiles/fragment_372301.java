public String generatePayCheck() {
    wage = getWage() / 26;
    vacationBalance = recordVacation(vacationBalance);
    return String.format("paycheck balance is %s and "
            + "vacation balance is %s",wage, vacationBalance);
}