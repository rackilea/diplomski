CharSequence inputString1 = editTextDate1.getText();
    try {
        LocalDate date1 = LocalDate.parse(inputString1, dateFormatter);
        CharSequence inputString2 = editTextDate2.getText();
        try {
            LocalDate date2 = LocalDate.parse(inputString2, dateFormatter);
            long diffDate = ChronoUnit.DAYS.between(date1, date2);
            txtResult.setText(String.valueOf(diffDate));
        } catch (DateTimeParseException dtpe) {
            Toast.makeText(this, "Date2 is not a valid date: " + inputString2, Toast.LENGTH_SHORT).show();
        }
    } catch (DateTimeParseException dtpe) {
        Toast.makeText(this, "Date1 is not a valid date: " + inputString1, Toast.LENGTH_SHORT).show();
    }