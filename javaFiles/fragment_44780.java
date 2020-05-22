public class UtilsDialect implements IExpressionEnhancingDialect {

    public static final String UTILS_EXPRESSION_OBJECT_NAME = "utils";

    private final Variety utils;

    public UtilsDialect (final Variety utils){
        this.utils = utils;
    }

    @Override
    public Map<String, Object> getAdditionalExpressionObjects(final IProcessingContext processingContext) {
        final Map<String, Object> objects = new HashMap<>();
        objects.put(UTILS_EXPRESSION_OBJECT_NAME, variety);
        return objects;
    }
}