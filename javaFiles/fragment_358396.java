LocalDate ld1 = LocalDateTime.ofInstant(instant1, ZoneId.systemDefault()).toLocalDate();
LocalDate ld2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault()).toLocalDate();

if (ld1.isEqual(ld2)) {
    System.out.println("blubb");
}