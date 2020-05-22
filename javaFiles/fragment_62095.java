public class TenantSupplier extends Supplier<MapKey, MapValue, String> {

    @Override
    public String apply(Entry<MapKey, MapValue> entry) {
        return entry.getKey().getTenant();
    }   
}