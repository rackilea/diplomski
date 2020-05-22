input.stream()           // when using Java 9, use LocalDate.datesUntil() instead of building the stream of dates yourself
     .map(list -> Stream.iterate(minDate, date -> date.plusDays(1))
                        .limit(ChronoUnit.DAYS.between(minDate, maxDate) + 1)
                        .map(date -> list.stream()
                                         .filter(value -> date.equals(value.getDate()))
                                         .findAny()
                                         .orElse(new DateValue(date, 0.0)))
                        .collect(Collectors.toList()))
     .collect(Collectors.toList());