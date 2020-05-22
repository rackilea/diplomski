AjaxCallback<JSONObject> cb = new AjaxCallback<JSONObject>();
final AQuery aq = new AQuery(this);
cb.url(url).type(JSONObject.class);
aq.sync(cb);

JSONObject json = cb.getResult();
AjaxStatus status = cb.getStatus();
if (json != null && statusValid(status)) {
    // parse json object, throw if fails, etc.
}