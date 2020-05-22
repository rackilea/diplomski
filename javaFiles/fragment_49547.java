JsonObject root = (JsonObject)new JsonParser().parse(jsonString);  

int i=0;
JsonObject dataReports

//get and print each object of reports
while(root.getAsJsonObject().get("reports").getAsJsonArray().size()>i && (dataReports=root.getAsJsonObject().get("reports").getAsJsonArray().get(i).getAsJsonObject())!=null){  

    System.out.println(dataReports.toString());
    i++;
}