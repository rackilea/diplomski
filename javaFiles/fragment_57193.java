@RestController
@RequestMapping("/")
public class AppB_RestController {

    @PostMapping(value = "some-api")
    public ResponseEntity<ByteArrayResource> generateExcelFile(@RequestBody SomeDTO dto) {
        // Do stuff...
        OutputStream os = new ByteArrayOutputStream();
        excelFile.getWorkbook().write(os); // apache.poi workbooks can be written to streams
        ByteArrayResource res = new ByteArrayResource(os.getByteArray());
        return ResponseEntity.ok(res);
    }
}