catch (InputMismatchException n) { // catching long,strings and doubles in the payroll.txt that aren't valid
                StringBuilder sb = new StringBuilder();
                sb.append(EmployeeNumber == 0 ? "" : (EmployeeNumber + " "));
                sb.append(EmployeeName == null ? "" : (EmployeeName + " "));
                sb.append(LastName == null ? "" : (LastName + " "));
                sb.append(HoursWorked == 0.0 ? "" : (HoursWorked + " "));
                sb.append(HourlyWage == 0.0 ? "" : (HourlyWage + " "));
                sb.append(txtIn.nextLine());
                txtOut.println(sb.toString());
            }