@RestController
@RequestMapping("/some-route")
public class AppA_RestController {

    private AppB_Connecor connector;

    @PostMapping(value = "/some-handler")
    public ResponseEntity<byte[]> handleUserPostRequest(@RequestBody SomeDTO dto) {
        return connector.fetchFile(dto);
    }
}

public class AppB_Connecor {

    public byte[] fetchFile(SomeDTO dto) {
        HttpHeaders headers = jsonType();
        HttpEntity<SomeDTO> entity = new HttpEntity<>(dto, headers);
        RestTemplate rest = jsonRestTemplate(); // Just Jackson JSON-object mapper
        String url = "http://some-website.abc/some-api";
        return rest.postForObject(url, entity, byte[].class);
    }
}