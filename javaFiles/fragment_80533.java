datePicker.setConverter(new StringConverter<LocalDate>() {
     String pattern = "yyyy-MM-dd";
     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

     {
         datePicker.setPromptText(pattern.toLowerCase());
     }

     @Override public String toString(LocalDate date) {
         if (date != null) {
             return dateFormatter.format(date);
         } else {
             return "";
         }
     }

     @Override public LocalDate fromString(String string) {
         if (string != null && !string.isEmpty()) {
             return LocalDate.parse(string, dateFormatter);
         } else {
             return null;
         }
     }
 });