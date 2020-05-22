DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/u");
    String formationDateString = JOptionPane.showInputDialog("Association Formation Date (dd/mm/yyyy) ");
    try {
        LocalDate formDate = LocalDate.parse(formationDateString, dateFormatter);
    } catch (DateTimeParseException dtpe) {
        JOptionPane.showMessageDialog(null, "Invalid date format",
                "id frn’s app", JOptionPane.ERROR_MESSAGE);
    }