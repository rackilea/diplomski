public class JsonHelper{

    public static String cratePWMJSON(int PWM1, int PWM2, int PWM3, int PWM4, int PWM5, int PWM6, int PWM7){
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try {
            //jsonArray.put("");
            jsonArray.put(PWM1 * 64);
            jsonArray.put(PWM2 * 64);
            jsonArray.put(PWM3 * 64);
            jsonArray.put(PWM4 * 64);
            jsonArray.put(PWM5 * 64);
            jsonArray.put(PWM6 * 64);
            jsonArray.put(PWM7 * 64);
            jsonObject.put("PWMs", jsonArray); 
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSO", "Received JSON String: " + jsonObject.toString());
        return jsonObject.toString();
    }
}