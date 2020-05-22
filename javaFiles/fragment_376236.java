ParseCloud.callFunctionInBackground("listScheduledEmails", params, new FunctionCallback<Object>() {
    public void done(Object o, ParseException e) {
        if (e == null) {
            Log.i("Tag", "Return type = " + o.getClass().getName());
        }
    }
});