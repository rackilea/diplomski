LocalDate date = LocalDate.now();
int nbMonthRemain = 12 - date.getMonth().getValue();

String[] monthsRemaining = new String[nbMonthRemain + 1];
for (int i = 0; i < monthsRemaining.length; i++) {
    monthsRemaining[i] = date.plusMonths(i).getMonth().toString();
}

System.out.println(Arrays.toString(monthsRemaining)); // [OCTOBER, NOVEMBER, DECEMBER]