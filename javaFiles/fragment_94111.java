@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="...")
public class Controller {

    @Autowired
    private ApplicationContext ctx;

    @PostMapping(path= { "..." })
    public ApiResponse<?> post() {

        try {
            // ...

            ObjectMapper om = (ObjectMapper) ctx.getBean("jacksonMapper");

            // ...

            return new ApiResponse<>();
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

}