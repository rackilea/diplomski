@PostMapping("/toLinPDf")
public ResponseEntity<ByteArrayResource> convertion(
    @RequestParam(value = "input", required = false) String in,
    @RequestParam(value = "output", required = false) String out) throws IOException, InterruptedException {
ExecutorService executorService = Executors.newSingleThreadExecutor();
Callable<String> callable = () -> {
        linearizeService.LinearizePDf(in, out);
        return "Task ended";
};
Future<String> future = executorService.submit(callable);
String result = future.get();
executorService.shutdown();
FileSystemResource pdfFile = new FileSystemResource(out);
return ResponseEntity
            .ok()
            .contentLength(pdfFile.contentLength())
            .contentType(
                    MediaType.parseMediaType("application/pdf"))
            .body(new ByteArrayResource(IOUtils.toByteArray(pdfFile.getInputStream())));

}