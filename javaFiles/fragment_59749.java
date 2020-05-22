Pattern pattern = Pattern.compile("[a-zA-Z]*");
UnaryOperator<TextFormatter.Change> filter = c -> {
    if (pattern.matcher(c.getControlNewText()).matches()) {
        return c ;
    } else {
        return null ;
    }
};
TextFormatter<String> formatter = new TextFormatter<>(filter);
txtFirstName.setTextFormatter(formatter);