// just create a random date sometime in 2016:
Random rng = new Random();
LocalDate random2016Date = LocalDate.of(2016, 1, 1).plusDays(rng.nextInt(365));

// general listener for logging:
ChangeListener<Object> listener = (obs, oldVal, newVal) -> System.out.println(oldVal + " -> " + newVal);


ObjectProperty<LocalDate> date = new SimpleObjectProperty<>(random2016Date);
date.addListener(listener);

// add one year to the current date:
date.set(date.get().plusYears(1));