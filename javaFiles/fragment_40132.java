public static int updateDBObjectJson(..., Class<? extends MyInterface> dbObject, ...) {
    ...
    JSONObject jObj = jArr.optJSONObject(i);

    Constructor<? extends MyInterface> ct = dbObject.getConstructor(JSONObject.class);
    MyInterface obj = ct.newInstance(jObj);
    ...
    boolean changed = upsertEntry(uri, obj, false);
    ...
}