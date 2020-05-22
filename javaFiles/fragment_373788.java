List<String> dates = Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .map(date -> date.format(DateTimeFormatter.BASIC_ISO_DATE))
                .collect(Collectors.toList());


System.err.println(dates);