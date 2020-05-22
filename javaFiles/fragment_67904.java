// Array to store the indexes of the JSONArray to remove
ArrayList<Integer> indexesToRemove = new ArrayList<Integer>();
// Iterate through projects array, check the object at each position
// if it contains the string you want, add its index to the removal list
for (int i = 0; i < projectsArray.length; i++) {
    JSONObject current = projectsArray.get(i);
    if (current.get("projectKey") == "**DESIRED PROJECT KEY**") {
        indexesToRemove.add(i);
    } 
}