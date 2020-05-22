ParseCloud.callFunctionInBackground("listScheduledEmails", params, new FunctionCallback<List<Map>>() {
    public void done(List<Map> list, ParseException e) {
        if (e == null) {
            ArrayList<ScheduledEmail> scheduledEmails = new ArrayList<>();

            for(Map<String, ?> data : list) {
                ScheduledEmail scheduledEmail = new ScheduledEmail();
                scheduledEmail.set_id(data.get("_id"));
                // ... extract rest of data

                scheduledEmails.add(scheduledEmail);
            }
        }
    }
});