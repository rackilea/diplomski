try {
            JSONObject json = new JSONObject();
            JSONObject aps = new JSONObject();

            aps.put("badge", 15);
            aps.put("alert", "Hello from Urban Airship!");
            aps.put("sound", "cat.caf");
            Log.d("my json string", json.put("aps", aps).toString(1));
        } catch (JSONException e) {
            e.printStackTrace();
        }