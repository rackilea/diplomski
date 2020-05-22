@GetMapping("/startDate/{startDate}/endDate/{endDate}")
public ResponseEntity<?> performSearchByDateAction(
        @PathVariable String startDateAsString,
        @PathVariable String endDateAsString) throws ParseException {
    DateTime lastChangedStart = null;
    try {
        lastCangedStart = DateTimeFormatter.parse(startDateAsString);
    } catch (java.time.format.DateTimeParseException e) {
         try { // second format
         } catch (java.time.format.DateTimeParseException e) {
              try { // third format
              } catch (java.time.format.DateTimeParseException e) {
         }
     } catch (java.time.format.DateTimeParseException e) {
    System.out.println(lastChangedStart);
    System.out.println(lastChangedEnd);

    return ResponseEntity.ok().build();
}