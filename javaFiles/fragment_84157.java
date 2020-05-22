asList("MMM", "LLL").forEach(ptrn
            -> System.out.println(ptrn + ": " + ofPattern(ptrn, Locale.ENGLISH).format(Month.APRIL))
    );
    Locale.setDefault(Locale.ENGLISH);
    String textM = "28-Apr-2015 01:25:00 PM";
    DateTimeFormatter formatterM = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss a");
    System.out.println(LocalDateTime.parse(textM, formatterM));

    String textL = "28-4-2015 01:25:00 PM";
    DateTimeFormatter formatterL = DateTimeFormatter.ofPattern("dd-LLL-yyyy hh:mm:ss a");
    System.out.println(LocalDateTime.parse(textL, formatterL));