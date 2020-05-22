private static final Gson gson = new GsonBuilder()
        .setDateFormat("yyyy-MM-dd")
        .registerTypeAdapterFactory(getFilterTypeAdapterFactory(jsonObject -> {
            if ( !jsonObject.has("fieldName") ) {
                return defaultFilterType;
            }
            switch ( jsonObject.get("fieldName").getAsString() ) {
            case "barInteger":
                return integerFilterType;
            case "fooDate":
                return dateFilterType;
            default:
                return defaultFilterType;
            }
        }))
        .create();