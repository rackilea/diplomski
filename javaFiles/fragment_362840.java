for (DataEvent event : dataEvents) {
        if (event.getType() == DataEvent.TYPE_CHANGED) {
            // DataItem changed
            DataItem item = event.getDataItem();
            if (item.getUri().getPath().compareTo("/shouldStart") == 0) {
                DataMap dataMap = DataMapItem.fromDataItem(item).getDataMap();
                boolean shouldStart = dataMap.getBoolean(SHOULD_START_KEY));
                if(shouldStart) {
                    Volley.newRequestQueue(this).add(request);
                }

            }
        } else if (event.getType() == DataEvent.TYPE_DELETED) {
            // DataItem deleted
        }
    }