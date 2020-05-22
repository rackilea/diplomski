@RestController
public class CommandController extends AbstractController {

    private final MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();

    @Override
    protected ModelAndView handleRequestInternal(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        // controller code here
        return new ModelAndView(mappingJackson2JsonView);
    }
}