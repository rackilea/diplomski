@Service
public class Html2PdfService {

    @Autowired
    private TemplateEngine templateEngine;

    public OutputStream template2Pdf(String templateName, Map parameters) {
//        OutputStream outputStream = new BufferedOutputStream();
//        IOUtils.copy()
//
//        Context ctx = new Context();
//        String processedHtml = templateEngine.process(templateName, ctx);
//        ITextRenderer renderer = new ITextRenderer();
//        renderer.setDocumentFromString(processedHtml);
//        renderer.layout();
//        renderer.createPDF(os, false);
//        renderer.finishPDF();
        return null;
    }

    public String template2Html(String templateName, Map parameters) {
        Context ctx = new Context();
        ctx.setVariable("name", "pippo");
        String processedHtml = templateEngine.process(templateName, ctx);
        return processedHtml;
    }
}