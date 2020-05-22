private void createJsonStructure() {

    try
    {
        JSONObject rootObject = new JSONObject();

        JSONArray carArr = new JSONArray();
        for (int i = 0; i < 2 ; i++)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("CarId", "123");
            jsonObject.put("Status", "Ok");
            carArr.put(jsonObject);
        }
        rootObject.put("Car", carArr);


        JSONArray motorArr = new JSONArray();
        for (int i = 0; i < 2 ; i++)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("MotorId", "123");
            jsonObject.put("Status", "Ok");
            motorArr.put(jsonObject);
        }
        rootObject.put("Motor", motorArr);


        JSONArray busArr = new JSONArray();
        for (int i = 0; i < 2 ; i++)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("BusId", "123");
            jsonObject.put("Status", "Ok");
            busArr.put(jsonObject);
        }
        rootObject.put("Bus", busArr);

        Log.e("JsonObject", rootObject.toString(4));

    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
}