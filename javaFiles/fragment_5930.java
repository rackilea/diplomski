@RequestMapping(value = "/upload", method = RequestMethod.POST)
public @ResponseBody
ResponseEntity<Map<String, Object>> handleFileUpload(
        @RequestParam("file1") MultipartFile file1,
        @RequestParam("file2") MultipartFile file2) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("status", "failure");
    try {
        if (!file1.isEmpty() && !file2.isEmpty()) {

            // get the files here

            map.put("status", "success");
        }
    } catch (Exception e) {
        LOGGER.severe(e.toString());
    }

    ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<Map<String, Object>>(
            map, HttpStatus.OK);

    return responseEntity;
}