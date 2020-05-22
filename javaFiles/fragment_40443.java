// Print everything in for loop
for (int i = 0; i < employee.length; i++) {
    totalHours[i] = 0;
    for (int j = 0; j < 7; j++) {
        totalHours[i] = totalHours[i] + hours[i][j];
    }
    // I THINK I NEED TO ADD SOMETHING HERE BUT I'M NOT SURE WHAT
    // Arrays.sort(totalHours); gives me the wrong output, I'm stuck

}

//patch starts here
int[] totalHoursSortedAsc = Arrays.copyOf(totalHours, totalHours.length);
Arrays.sort(totalHoursSortedAsc);
for (int i = totalHoursSortedAsc.length - 1;i>=0;i--) {
    for (int j = 0;j < totalHours.length;j++) {
        if (totalHoursSortedAsc[i] == totalHours[j]) {
            System.out.println("Employee " + (j + 1) + " worked " + totalHours[j] + " hours");
            totalHours[j] = -1; //Employees may work the same time
        }
    }
}