HashMap<String, String> map = new HashMap<String, String>();
StringBuilder sb = new StringBuilder();
for (Entry<String, String> entry : map.entrySet()) {
    sb.append('&').append(entry.getKey()).append('=').append(entry.getValue());
}
String result = sb.length() > 0 ? sb.substring(1) : "";