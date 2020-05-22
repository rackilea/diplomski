@Stateless
@LocalBean    
public class ResultEvaluationFacade {

    @Inject
    @Development
    private ResultEvalutationInterface dev;

    @Inject
    @Production
    private ResultEvalutionInterface prod;

    @Override
    public void evaluateResults(Event e) {
        switch (e.getType()) {
            case Type.Production:
               prod.evaluteResult(e);
               break;
            case Type.Development:
               dev.evaluteResult(e);
               break;
            default:
               throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}