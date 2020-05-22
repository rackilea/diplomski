if (!jObject.isNull("submissions")) {
    JSONArray submissions = jObject.getJSONArray("submissions");

    for(int i = 0; i < submissions.length(); i++) {
        JSONObject submission = submissions.getJSONObject(i);
        String submissionId = submission.getString("submission_id");
    }
}