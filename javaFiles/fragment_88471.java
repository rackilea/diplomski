import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.springframework.core.convert.ConversionService;
import org.springframework.context.ApplicationContext;

@Service
public class EmailService {

    @Autowired
    private SpringTemplateEngine templateEngine;

    // Inject this
    @Autowired
    private ApplicationContext applicationContext;

    // Inject this
    @Autowired
    private ConversionService mvcConversionService;

    public String prepareTemplate() {
        // ...
        Context context = new Context();
        // Add the below two lines
        final ThymeleafEvaluationContext evaluationContext = new ThymeleafEvaluationContext(applicationContext, mvcConversionService);
        context.setVariable(ThymeleafEvaluationContext.THYMELEAF_EVALUATION_CONTEXT_CONTEXT_VARIABLE_NAME, evaluationContext);
        this.templateEngine.process(template, context);
    }
}