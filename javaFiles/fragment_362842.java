for (DataEvent event : dataEvents) {
    if (event.getType() == DataEvent.TYPE_CHANGED) {
         // DataItem changed
         DataItem item = event.getDataItem();
         if (item.getUri().getPath().compareTo("/data") == 0) {
             DataMap dataMap = DataMapItem.fromDataItem(item).getDataMap();
             parseAndpassToAdapter(dataMap.getString(DATA_KEY));
         }
    } else if (event.getType() == DataEvent.TYPE_DELETED) {
            // DataItem deleted
    }
}