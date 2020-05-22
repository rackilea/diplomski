DatePicker dp = new DatePicker();
// Have to associate the TextFormatter with a TextField
TextFormatter<LocalTime> tf = new TextFormatter<>(new LocalTimeStringConverter());

ObjectBinding<LocalDateTime> binding = Bindings.createObjectBinding(() -> {
    LocalDate ld = dp.getValue();
    LocalTime lt = tf.getValue();
    return ld == null || lt == null ? null : LocalDateTime.of(ld, lt);
}, dp.valueProperty(), tf.valueProperty());