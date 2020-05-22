String deliverydate="02-SEP-2012";
DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("dd-MMM-yyyy")
                .toFormatter(Locale.UK);
LocalDate ld = LocalDate.parse(deliverydate, formatter);
System.out.println(ld);