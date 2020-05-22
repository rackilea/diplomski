@CrossOrigin
@RestController
public class ProcessFileController {
    @Autowired
    ProcessFileService processFileService;

    @CrossOrigin
    @PostMapping("/files/upload")
    public ResponseEntity<String> singleFileUpload(@RequestParam("file") MultipartFile file) {
        bytes = file.getBytes();
        // Save file...
        String plainText = new String(bytes, StandardCharsets.UTF_8);
        processFileInBackground(plainText);
        return new ResponseEntity<>("File successfully uploaded!", HttpStatus.OK);
    }


    private void processFileInBackground(String plainText) {
        processFileService = new ProcessFileService(plainText);
        String result = processFileService.getResult();
    }
}