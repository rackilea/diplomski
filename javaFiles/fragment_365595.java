JSONObject jsonObject=new JSONObject(readFromFile());  
    JSONArray array= jsonObject.getJSONArray("Samples");  

        JSONObject json=array.getJSONObject(0);  
        PatientJson patient=new PatientJson();  

        patient.setId(json.get("Id"));  
        patient.setSampleId(json.get("SampleId"));  
        patient.setGender(json.get("Gender"));  

 private String readFromFile(){
String ret = “”;

try {
InputStream inputStream = openFileInput("yourFile");

if ( inputStream != null ) {
InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
String receiveString = “”;
StringBuilder stringBuilder = new StringBuilder();

while ( (receiveString = bufferedReader.readLine()) != null ) {
stringBuilder.append(receiveString);
}

ret = stringBuilder.toString();

inputStream.close();
}
}
catch (FileNotFoundException e) {
Log.e(TAG, “File not found: ” + e.toString());
} catch (IOException e) {
Log.e(TAG, “Can not read file: ” + e.toString());
}
return ret;

}