String doctorInfo(String jsonString) {
    JSONObject obj = new JSONObject(jsonString)
    JSONArray arr = obj.getJSONArray("patientInfo")
    JSONObject patientJSONObject = arr.getJSONObject(0);
    String doctor = patientJSONObject.getString("doctor");
    return doctor;
}