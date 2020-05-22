Map<String, String> map = new HashMap<String, String>();
String[] arr = str.split("&");
for (String s : arr) {
    String[] a = s.split("=");
    map.put(a[0], a[1]);
}