@GetMapping("/download_file")
public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam("file_name") String fileName, Model model) {

    // Get the job's route url.
    String resourceUrl = ApiConfig.URL + "/" + ApiConfig.FILE_ROUTE  + "/" + fileName;

    // Create the request.
    ClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    RestTemplate restTemplate = new RestTemplate(requestFactory);

    // Execute the request.
    return restTemplate.getForEntity(resourceUrl, ByteArrayResource.class);
}