private static final DateTimeFormatter dateFormatter 
        = DateTimeFormatter.ofPattern("dd-MM-uuuu");

private static void getAge(String dob1) {
    LocalDate dob = LocalDate.parse(dob1, dateFormatter);
    LocalDate today = LocalDate.now(ZoneId.of("Asia/Dushanbe"));
    if (dob.isAfter(today)) {
        System.out.println("Future date not allowed");
    } else {
        int age = (int) ChronoUnit.YEARS.between(dob, today);

        if (age < 18) {
            System.out.println(age);
            System.out.println("Underage");
        } else {
            System.out.println(age);
            System.out.println("18 years");
            //Some logic
        }
    }
}