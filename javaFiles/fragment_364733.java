JSONObject objJsonInput = new JSONObject("{\"uuId\" :\"val1\",  \"logtime\"     :\"val2\",  \"taskid\"      :\"val3\",  \"taskName\"    :\"val4\"}");
FieldsValidation validation = checkMandatoryFields(objJsonInput, "uuId", "logtime", "taskid", "taskName");
System.out.println(validation.allFieldsOk);

objJsonInput = new JSONObject("{\"uuId\" :\"val1\",  \"logtime\"     :\"val2\",  \"\"      :\"val3\"}");
validation = checkMandatoryFields(objJsonInput, "uuId", "logtime", "taskid", "taskName");
System.out.println(validation.allFieldsOk);
for (String message : validation.fieldErrors) System.out.println(message);