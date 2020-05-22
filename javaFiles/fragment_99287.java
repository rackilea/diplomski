StringBuilder json = new StringBuilder("{");
for (Map.Entry < String, String > entry: map.entrySet()) {
    json.append(entry.getKey() + ":" + entry.getValue()).append(",");
}
//removes the last "," which is unnecessary
json.deleteCharAt(json.lastIndexOf(","));
json.append("}");
return json.toString();