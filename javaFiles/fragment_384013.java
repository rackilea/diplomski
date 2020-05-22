@Controller
public class HelloWorldController {

    @Autowired
    private Html2PdfService pdfService;

    @GetMapping(path = "/test")
    public String hello() {
        Map parameters = new HashMap();
        parameters.put("name", "Borat");
        System.out.println(pdfService.template2Html("test", parameters));
        return "test";
    }

//    @ResponseBody
//    @GetMapping
//    public ResponseEntity helloPdf() {
//        Map parameters = new HashMap();
//        parameters.put("name", "Borat");
//        pdfService.template2Pdf("test", parameters);
//        String filePath = "PATH_HERE";
//        InputStream inputStream = new FileInputStream(new File(filePath));
//        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentLength();
//        return new ResponseEntity(inputStreamResource, headers, HttpStatus.OK);
//    }
}