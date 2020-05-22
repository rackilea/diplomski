@Controller("/")
public class IndexController {
    @Inject
    ResourceResolver res;


    @Get("/{[path:[^\\.]*}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    @Produces(MediaType.TEXT_HTML)
    public HttpResponse<?> refresh(HttpRequest<?> request) {
        StreamedFile indexFile = new StreamedFile(res.getResource("classpath:public/index.html").get());
        return HttpResponse.ok(indexFile);
    }
}