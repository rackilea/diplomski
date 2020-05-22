} catch (Exception e) {
    logger.error(e);

} catch (Throwable t) {
    logger.error(t);

} finally {
    closeMailStore(store, folder); // just simple method which closes the store
}