@RestController
@RequestMapping("/files")
public class FileController {

    @GetMapping("/{fileName}")
    public Resource getFile(@PathVariable String fileName) {
        Resource resource = new FileSystemResource(fileName);        
        return resource;
    }
}