// check for success tag
    int success;
    try {
        success = json.getInt(TAG_SUCCESS);
        if (success == 1) {
            // successfully check-in
            return "Check-in success";
        } else {
            // failed to check-in
            return "Failed";
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }