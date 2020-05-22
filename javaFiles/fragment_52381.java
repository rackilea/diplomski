private void handleAll(RuntimeException e) {
    try {
        throw e;
    } catch (XException xe) {
        ...
    } catch (YException xe) {
        ...
    } catch (ZException xe) {
        ...
    }
}