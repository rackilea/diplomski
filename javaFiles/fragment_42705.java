JSONObject jsonObject1 = (JSONObject) object;
JSONArray fields= (JSONArray) jsonObject1.get("Angular2");

for (Object field: fields) {
JSONObject jsonObject = (JSONObject) field;

        //Reading the String
        String tech = (String) jsonObject.get("Technology");
        String vul = (String) jsonObject.get("Vulnerability");
        String sev = (String) jsonObject.get("Severity");
        String regex = (String) jsonObject.get("RegEx");

        //Printing all the values
        System.out.println("Technology: " + tech);
        System.out.println("Vulnerability: " + vul);
        System.out.println("Severity: "  + sev);
        System.out.println("RegEx: "  + regex);
}