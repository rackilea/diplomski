char separator = "";
StringBuilder sb = new StringBuilder();

while (rs.next()) {
    sb.append(separator).append(rs.getString(1));
    separator = ",";
}

jArray.put(new JSONArray(sb.toString()));