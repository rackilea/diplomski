public class HeaderController extends ViewPreparerSupport{
private EvalTypesService evalTypesService;

@Autowired
public HeaderController(EvalTypesService evalTypesService){
    this.evalTypesService = evalTypesService;
}

@Override
public void execute(TilesRequestContext tilesContext, AttributeContext attributeContext) throws PreparerException{
    List<EvalMasterEvaluationType> evalTypes = evalTypesService.getAllActiveEvalTypes();
    tilesContext.getRequestScope().put("evalTypes", evalTypes);
}