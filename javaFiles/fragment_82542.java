import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PdfJsRedirectController {
    private static final String WORKER_JS_INCORRECT_PATH = "/APP/PUBLISHED/pdf.worker.js";
    private static final String WORKER_JS_CORRECT_FORWARD_PATH = "forward:/vaadinServlet/APP/PUBLISHED/pdf.worker.js";

    @RequestMapping(value = WORKER_JS_INCORRECT_PATH)
    public String forwardWorkerJsRequestToVaadin() {
        return WORKER_JS_CORRECT_FORWARD_PATH;
    }
}