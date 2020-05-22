String endDateValue = "07/01/2013";

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
LocalDate endDate = LocalDate.parse(endDateValue, formatter);
LocalDate startDate = endDate.minusMonths(6);

String startDateValue = formatter.format(startDate);