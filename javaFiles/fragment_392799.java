List<String> actualCSVRecords =  
    CSVFormat.RFC4180
             .parse(actualCSVReader)
             .getRecords()
             .stream()
             .map(Object::toString)
             .collect(Collectors.toList());

List<String> expectedCSVRecords =
     CSVFormat.RFC4180
             .parse(expectedCSVReader)
             .getRecords()
             .stream()
             .map(Object::toString)
             .collect(Collectors.toList());

Assert.assertEquals(expectedCSVRecords, actualCSVRecords);