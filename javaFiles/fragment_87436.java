@SuppressWarnings("rawtypes")
    public static int getResourceId(String name,  Class resType){

        try {
            Class res = null;
            if(resType == R.drawable.class)
                res = R.drawable.class;
            if(resType == R.id.class)
                res = R.id.class;
            if(resType == R.string.class)
                res = R.string.class;
            Field field = res.getField(name);
            int retId = field.getInt(null);
            return retId;
        }
        catch (Exception e) {
           // Log.d(TAG, "Failure to get drawable id.", e);
        }
        return 0;
    }