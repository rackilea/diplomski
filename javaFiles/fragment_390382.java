// SAVE LISTENER
public class SaveListener extends DefaultSaveEventListener {

    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) {
        if (event.getObject() instanceof BaseTimestamps) {
            BaseTimestamps record = (BaseTimestamps) event.getObject();
            record.setCreatedAt(new Date());
        }

        super.onSaveOrUpdate(event);
    }

}

// UPDATE LISTENER
public class UpdateListener extends DefaultUpdateEventListener {

    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) {
        if (event.getObject() instanceof BaseTimestamps) {
            BaseTimestamps record = (BaseTimestamps) event.getObject();
            record.setUpdatedAt(new Date());
        }

        super.onSaveOrUpdate(event);
    }

}