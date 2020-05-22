public class CustomRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        if(Tenant.getCurrentTenant() == null) {
            return "TENANT1";
        }
        return Tenant.getCurrentTenant().toUpperCase();
    }
}