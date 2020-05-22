@RestController
public class YourRest {

    ...

    @Autowired
    private ContentNegotiationManager contentNegotiationManager;

    @RequestMapping(value = "types", method = RequestMethod.GET)
    public Set<String> getConfiguredMediaTypes() {
        return Optional.of(contentNegotiationManager)
                .map(m -> m.getStrategy(ParameterContentNegotiationStrategy.class))
                .map(s -> s.getMediaTypes().keySet())
                .orElse(Collections.emptySet());
    }

    ...
}