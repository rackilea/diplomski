public static void main(String args[]) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date= LocalDate.parse("02/04/2017", dtf );
    System.out.println(isYearPast(date));                                    // false
    System.out.println(isYearPast(LocalDate.parse("02/04/2012", dtf )));     // true
}

public static boolean isYearPast(LocalDate date){
    return date.getYear() < LocalDate.now().getYear();
}