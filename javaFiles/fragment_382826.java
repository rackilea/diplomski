public class SingleHomeCardItem extends JSONObject {
private static final String TAG = SingleHomeCardItem.class.getSimpleName();

public static final String subtitle = "subtitle";
public static final String badgeNumber = "badgeNumber";
public static final String backgroundUrl = "backgroundUrl";
public static final String backgroundGradient = "backgroundGradient";
public static final String targetUrl = "targetUrl";
public static final String target = "target";
public static final String row = "row";

public SingleHomeCardItem(String json) throws JSONException {
    super(json);
}

public SingleHomeCardItem(JSONObject json) throws JSONException {
    super(json.toString());
}

public String getSubtitle() {
    return optString(subtitle, "");
}

public String getBadgeNumber() {
    return optString(badgeNumber, "");
}

public String getBackgroundUrl() {
    return optString(backgroundUrl, "");
}

public String getBackgroundGradient() {
    return optString(backgroundGradient, "");
}

public String getTargetUrl() {
    return optString(targetUrl, "");
}

public String getTarget() {
    return optString(target, "");
}
public String getRow() {
    return optString(row, "");
}
}