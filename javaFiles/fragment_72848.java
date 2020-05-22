//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;

String s = "190415";
DateTimeFormatter dtfIn = DateTimeFormatter.ofPattern("yyMMdd");
DateTimeFormatter dtfOut = DateTimeFormatter.ofPattern("yyyyMMdd");

LocalDate ld = LocalDate.parse(s, dtfIn);
System.out.println("NEW : " + dtfOut.format(ld));