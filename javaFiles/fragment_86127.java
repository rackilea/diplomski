String xml = "<test>111</test>";
    JSONObject json = XML.toJSONObject(xml);
    JSONTokener tokener = new JSONTokener(json.toString()) {
        public Object nextValue() throws JSONException {
            Object nextValue = super.nextValue();
            if (nextValue instanceof Number) {
                Number value = (Number) nextValue;
                return value.toString();
            }
            return nextValue;
        }
    };
    json = new JSONObject(tokener);
    System.out.println(json.toString());