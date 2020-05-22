public final class LazyTigerFactory {
    private Manager manager;
    public Manager getTiger()
    {
        //  If we haven't already done so,  get the tiger.
        if (tiger == null) {
            try {
                tiger= EntityResolution.getTigerFromName(ResTools.resolveNoTranslation(getConfigBundle(), "tiger", ""));
            } catch (Exception e) {
                LogTools.error(logger, null, e);
                return null;
            }
        }
        return tiger;
    }
}