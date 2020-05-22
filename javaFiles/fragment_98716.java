@RestController
@RequiredArgsConstructor
public class DownloadDocumentController {

    private static final String APPLICATION_MS_WORD_VALUE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

    private final DownloadDocumentService downloadDocumentService;

    @PostMapping(value = "/download", produces = APPLICATION_MS_WORD_VALUE)
    public ResponseEntity<byte[]> downloadFile(@RequestBody String pathFile) throws IOException {
        byte[] content = downloadDocumentService.downloadFile(pathFile);

        return ResponseEntity.ok()
                             .contentLength(content.length)
                             .header(HttpHeaders.CONTENT_TYPE, APPLICATION_MS_WORD_VALUE)
                             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "File.docx"))
                             .body(content);
    }
}