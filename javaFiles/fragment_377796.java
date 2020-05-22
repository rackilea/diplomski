@Controller
public class IndexController {

@RequestMapping(value = "/**/{[path:[^\\.]*}")
public String index(final HttpServletRequest request) {
    final String url = request.getRequestURI();

    if (url.startsWith("/static")) {
        return String.format("forward:/%s", url);
    }

    return "forward:/static/index.html";
}
}