String str=
 "{
"key":{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "employee_id": {
      "type": "string"
    },
    "course_id": {
      "type": "string"
    },
    "college_id": {
      "type": "string"
    }
  },
  "required": [
    "employee_id",
    "course_id",
    "college_id"
  ]
}
}
";  



        JSONObject jsonObj=new JSONObject(str);
       JSONObject keyJon= jsonObj.getJSONObject("key");
       String strUrl=keyJon.getString("$schema");
       System.err.println("str  "+strUrl);