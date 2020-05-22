public <T extends View> T attachWidget(Class<T> type, int resID, String name) throws AttachWidgetException {
        View view = findViewById(resID);
        if (view == null) throw new AttachWidgetException(name);
    try {
        return type.cast(view);  
    } catch (ClassCastException) {
        e.printStackTrace();
        throw new AttachWidgetException(name);
    } 
}