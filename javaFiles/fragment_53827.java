@RequestMapping(value = "/batchMonitor/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> process(@PathVariable("id") Long id) {
        HttpHeaders responseHeaders = MccControllerUtils.createCacheDisabledHeaders();
        responseHeaders.setContentType(MediaType.TEXT_HTML);
        try {
            LOGGER.info("Obtaining job by ID " + id);
            String response = batchService.process(id);
            return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error obtaining batch by ID " + id, e);
            return new ResponseEntity<>(e.getMessage(), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }