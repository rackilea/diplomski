@RequestMapping(value = "/api/v1/climates/locationdates/{location}/{sdate}/{edate}", method = RequestMethod.GET)
    public ResponseEntity<Object> getClimate(@PathVariable("location") long location,
            @PathVariable("sdate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime sdate,
            @PathVariable("edate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime edate) {

         System.out.println("CONTROLLER location is " + location + " start is " + sdate + " end is " + edate);           
         return new ResponseEntity<>(climateService.getClimatesByLocationAndDates(location, sdate, edate), HttpStatus.OK);
   }