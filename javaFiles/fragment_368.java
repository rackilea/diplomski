List<String[]> csvContentsList = csvParser.getRecords()
        .stream() 
        .sequential() // 1.
        .map((csvRecord) -> new String[]{
            csvRecord.get(0), 
            csvRecord.get(1), 
            csvRecord.get(2)
        }) // 2.
        .filter(v -> Arrays.stream(v)
                .filter(t -> t != null)
                .findFirst()
                .isPresent()
        ) // 3.
        .collect(Collectors.toList()); // 4.