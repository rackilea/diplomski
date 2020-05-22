String jsonString = "{    \"account\": \"Kpatrick\",    \"firstname\": \"Patrick\",    \"instances\": [        {            \"id\": \"packerer-pool\",            \"key\": \"packerer-pool123\",            \"userAccount\": \"kpatrick\",            \"firstname\": \"Patrick\",            \"lastname\": \"Schmidt\"        }    ],    \"projects\": [        {            \"id\": \"packerer-projectPool\",            \"projectKey\": \"projectPool-Pool\",            \"cqprojectName\": \"xxxxx\"        },        {            \"id\": \"packerer-secondproject\",            \"projectKey\": \"projectPool-Pool2\",            \"cqprojectName\": \"xxxx\"        },        {            \"id\": \"packerer-thirdproject\",            \"projectKey\": \"projectPool-Pool3\",            \"cqprojectName\": \"xxxx\"        }    ],    \"clients\": [],    \"dbid\": 76864576,    \"version\": 1,    \"id\": \"dbpack21\"}";
JSONParser parser = new JSONParser();
JSONObject jsonObject = (JSONObject) parser.parse(jsonString);

ArrayList<String> listOfNodes = new ArrayList<String>();
JSONArray projectArray = (JSONArray) jsonObject.get("projects");
int len = projectArray.size();
if (projectArray != null) {
    for (int i = 0; i < len; i++) {
        String projectId = ((JSONObject) projectArray.get(i)).get("projectKey").toString();
        if (!projectId.equals("projectPool-Pool2")) {
            listOfNodes.add(projectArray.get(i).toString());

        }

    }
}
// Remove the element from arraylist
// Recreate JSON Array
JSONArray jsArray = new JSONArray();
jsArray.addAll(listOfNodes);
jsonObject.remove(projectArray);
jsonObject.put("projects", listOfNodes);

System.out.println(jsonObject.toString());