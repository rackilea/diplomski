abstract class Z {

    final StatusEntry getServiceStatus(Supplier<StatucBType> statusProvider) throws Exception {
        StatusEntry result = new StatusEntry();
        ServiceStatus status;
        try {
            status = statusProvider.get().getStatus();
        } catch (Exception e) {
        }
        result.Status(status);
        return result;
    }

}