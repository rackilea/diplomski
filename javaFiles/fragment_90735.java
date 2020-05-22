@RequestMapping(value = "/ristore/foundation/{trf}", method = RequestMethod.GET, produces = "application/xml")
    public ResponseEntity<InputStreamResource> downloadXMLFile(@PathVariable("trf") String trf)
            throws IOException {

        // Optinal headers configuration 

HttpHeaders headers = new HttpHeaders();

        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");


        // get the inputStream

    InputStream xmlFileInputStream = ristoreService.findByTRF(trf);



        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(xmlFileInputStream));
    }