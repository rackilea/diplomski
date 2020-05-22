String salary = in.nextLine();
int salaryValue;
try {
    salaryValue = Integer.parseInt(salary);
} catch (NumberFormatException e) {
    System.out.println("You didn't enter a valid integer.");
}