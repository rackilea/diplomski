out.write("function centerChanged() {");
int lat=0,lng=0;
lat=;
out.write("map.getCenter().lat();");
lng=;
out.write("map.getCenter().lng();");
//request.setAttribute("lat", lat);
//request.setAttribute("lng", lng);
out.write("}");