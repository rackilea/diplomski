public class TerminationController extends AbstractController {

    private TerminationValidator terminationValidator;

    @Autowired
    public setDefaultTerminationValidator(TerminationValidator validator) {
        this.terminationValidator = validator;
    }

    @InitBinder("termination")
    public void initBinder(WebDataBinder binder, HttpServletRequest request) {
        binder.setValidator(terminationValidator);
        binder.setAllowedFields(new String[] { "termId[**]", "terminationDate",
                "accountSelection", "iban", "bic" });
    }

    [...]
}