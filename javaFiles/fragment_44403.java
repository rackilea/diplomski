@Log4j
public class PopulateInlineEntry implements OnWriteFeedContent {

    @Override
    public WriteFeedCallbackResult retrieveFeedResult(final WriteFeedCallbackContext writeFeedCallbackContext) throws ODataApplicationException {
        final EntityProviderWriteProperties currentWriteProperties = writeFeedCallbackContext.getCurrentWriteProperties();

        final WriteFeedCallbackResult result = new WriteFeedCallbackResult();
        result.setInlineProperties(currentWriteProperties);
        result.setFeedData(Lists.<Map<String, Object>>newArrayList(
                new ImmutableMap.Builder<String, Object>()
                        .put("Lgnum", "IN01")
                        .put("Huident", "1")
                        .put("Epc", "1")

                        .build(),
                new ImmutableMap.Builder<String, Object>()
                        .put("Lgnum", "IN01")
                        .put("Huident", "1")
                        .put("Epc", "2")

                        .build()
        ));

        return result;
    }

}