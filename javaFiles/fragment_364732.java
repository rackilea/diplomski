private class FieldsValidation
{
    public boolean allFieldsOk = false;
    public List<String> fieldErrors = new ArrayList<String>();
}

public static final String ERROR_MESSAGE = "The mandatory field %s is not defined !";

public FieldsValidation checkMandatoryFields(JSONObject objJsonInput, String... keys)
{
    FieldsValidation result = new FieldsValidation();
    for (String key : keys)
    {
        if (!objJsonInput.has(key) || objJsonInput.getString(key).isEmpty())
        {
            result.fieldErrors.add(String.format(ERROR_MESSAGE, key));
        }
    }
    result.allFieldsOk = result.fieldErrors.isEmpty();
    return result;
}