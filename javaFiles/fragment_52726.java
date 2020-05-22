String src = " { ... } "; //your json
JSONObject mainObject= new JSONObject(src);
JSONArray dataArray= mainObject.getJSONArray("data");
JSONObject firstDataObject = dataArray.getJSONObject(0); //get the first element
JSONObject educationObject = firstDataObject.getJSONObject("education");
JSONArray activitiesArray = educationObject.getJSONArray("Activities");
//do something with the array. Ex: activitiesArray.getJSONObject(0);
JSONArray prizesArray = educationObject.getJSONArray("Prizes");
//do something with the array
JSONArray curriculumArray = educationObject.getJSONArray("Curriculum");
//do something with the array