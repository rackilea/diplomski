// JSONObject objtemp = new JSONObject();
for (int i = 0; i < tempvals.length; ++i) {
  // objtemp.clear(); // <-- only one objtemp.
  JSONObject objtemp = new JSONObject();
  details = tempvals[i].split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
  objtemp.put("inspectionDate", details[7]);
  objtemp.put("code", details[9]);
  objtemp.put("description", details[10]);
  objtemp.put("score", details[12]);
  objtemp.put("grade", details[13]);
  objtemp.put("gradeDate", details[14]);
  arr.add(objtemp);
}
obj.put("violationDetails", arr);
// arr.clear(); // <-- would empty arr in `obj`.