@Override
public void push(String value) {
    Display.getInstance().callSerially(() -> {
        if (value.startsWith("{") || value.startsWith("[")) {
            try {
                JSONObject response = new JSONObject(value);

                switch (response.getString("action")) {
                    case "openMainForm":
                        //do whatever you want here
                        break;
                    default:
                        //perform default action here
                        break;
                }
            } catch (JSONException err) {
                Log.e(err);
            }
        }
    });
}