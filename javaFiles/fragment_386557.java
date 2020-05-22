@Component
public class MyFilterBean extends OncePerRequestFilter {

    @Autowired
    RequestMappingHandlerMapping mappings;

}