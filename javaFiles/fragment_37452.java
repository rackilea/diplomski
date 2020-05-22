private static final Gson gson = new GsonBuilder()
        .setDateFormat("yyyy-MM-dd")
        .registerTypeAdapterFactory(getFilterTypeAdapterFactory(jsonObject -> {
            if ( !jsonObject.has("_type") ) {
                return defaultFilterType;
            }
            switch ( jsonObject.get("_type").getAsString() ) {
            case "int":
                return integerFilterType;
            case "date":
                return dateFilterType;
            default:
                return defaultFilterType;
            }
        }))
        .create();