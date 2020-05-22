@ReadingConverter
public class SnapshotReadingConverter implements Converter<DBObject, Snapshot> {

    @Override
    public Snapshot convert(DBObject source) {
        long id = (Long) source.get("_id");
        String description = (String) source.get("description");
        boolean active = (Boolean) source.get("active");
        boolean billable = false;
        if (source.get("billable") != null) {
            billable = (Boolean) source.get("billable");
        }
        return new Snapshot(id, description, active, billable);
    }
}