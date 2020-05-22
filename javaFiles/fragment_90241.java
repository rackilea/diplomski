public static void main(String[] args) {

    String str1 = "22/04/2018";
    String str2 = "22/01/2018";
    System.out.println(isPast(str1));
    System.out.println(isPast(str2));
  }


  private static boolean isPast(String dateStr) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dates = LocalDate.parse(dateStr, formatter);

    return dates.isBefore(LocalDate.now());
  }