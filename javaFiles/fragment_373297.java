static final ImmutableMap<Long, String> ROMAN_MONTHS = ImmutableMap.<Long, String>builder()
                .put(1L, "I").put(2L, "II").put(3L, "III").put(4L, "IV").put(5L, "V")
                .put(6L, "VI").put(7L, "VII").put(8L, "VIII").put(9L, "IX").put(10L, "X")
                .put(11L, "XI").put(12L, "XII").build();

DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendValue(ChronoField.DAY_OF_MONTH, 1, 2, SignStyle.NORMAL)
                    .appendLiteral(' ')
                    .appendText(ChronoField.MONTH_OF_YEAR, ROMAN_MONTHS)
                    .appendLiteral(' ')
                    .appendValue(ChronoField.YEAR, 4)
                    .toFormatter();

System.out.println("My date " + formatter.parse("5 X 2012"));