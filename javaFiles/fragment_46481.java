@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/movies")
    public @ResponseBody MovieDTO findById(@RequestParam String id) {
        MovieInterface movie = movieService.findById(id);
        return MovieDTO.from(movie);
    }

}