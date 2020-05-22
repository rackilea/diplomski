DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Map<Date, Date> corrections = new HashMap<>(5500); // capacity for 11 years
    LocalDate endDate = LocalDate.of(2020, Month.DECEMBER, 31);
    LocalDate currentDate = LocalDate.of(2010, Month.JANUARY, 1);

    do {
        Date correctDate = Date.valueOf(currentDate);
        String correctString = correctDate.toString();
        Date wrongDate = new Date(dateFormat.parse(correctString).getTime());

        if (corrections.containsKey(wrongDate)) {
            System.out.println("Duplicate wrong date " + wrongDate);
        }

        corrections.put(wrongDate, correctDate);

        currentDate = currentDate.plusDays(1);
    } while (! currentDate.isAfter(endDate));