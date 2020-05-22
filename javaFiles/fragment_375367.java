@RestController
public class ConfigurationEndPoint {

    @Autowired
    FileTypeService fileTypeService;
    @GetMapping("/api/filetypes")
    @ResponseBody
    public ResponseEntity<List<String>> getDocumentTemplatesFileTypes(){
        return ResponseEntity.ok(fileTypeService.getFileTypes());
    }
}