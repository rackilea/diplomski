public class CleanHtmlDialect extends AbstractDialect
        implements IExpressionEnhancingDialect {
    // ...

    @Override
    public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
        Map<String, Object> expressionObjects = new HashMap<>();
        expressionObjects.put("cleanHtml", new CleanHtml());
        return expressionObjects;
    }
}