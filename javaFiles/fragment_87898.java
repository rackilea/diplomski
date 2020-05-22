new DataCollectClass(new OnDataCollectedCallback() {
        @Override
        public void onDataCollected(JSONObject data) {
            if(data != null)
                // DO something with your data
        }
    }).execute(requestURI, formVars);