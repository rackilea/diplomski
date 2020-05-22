StringBuilder builder = new StringBuilder (employeeNamesA.length);
    for (int i=0; i<employeeNamesA.length; i++))
        {
        for(int j=0; j<2; j++)
            builder.append(employeeNamesA[i][j]+"\n");
        }
    JOptionPane.showMessageDialog(null, "Employees with new Salary: " + builder.toString() + "PBI will now be paying this much more in total salary: $" + (totalSalary - totalNewSalary));