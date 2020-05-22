@RestController
@RequestMapping("/files")
public class FileController {

    @GetMapping("/{fileName}")
    public Mono<Resource> getFile(@PathVariable String fileName) {
        return fileRepository.findByName(fileName)
                 .map(name -> new FileSystemResource(name));
    }
}