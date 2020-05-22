int minValue = Integer.MAX_VALUE;
    int employeeWithMinValue = -1;
    for (int col = 0; col < hrsWrkd.length; col++) {
        int tempSum = 0;
        for (int row = 0; row < hrsWrkd[col].length; row++) {
            tempSum = tempSum + hrsWrkd[col][row];
        }
        if (tempSum < minValue) {
            minValue = tempSum;
            employeeWithMinValue = col;
        }
    }
    JOptionPane.showMessageDialog(null, "Employee number " + employeeWithMinValue +
            " worked only " + minValue + " hours");