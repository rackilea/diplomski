@Component
@RequiredArgsConstructor
public class RequestHelper {
    private final HttpServletRequest httpServletRequest;

    /* https://stackoverflow.com/questions/12249721/spring-mvc-3-how-to-get-path-variable-in-an-interceptor/23468496#23468496 */
    public Object getPathVariableByName(String name) {
        final Map pathVariables = (Map) httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        return pathVariables.get(name);
    }
}