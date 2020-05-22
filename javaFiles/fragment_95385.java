JSONObject obj = new JSONObject();
obj.put("name", "xyz");
obj.put("address", "address here");
obj.put("ipdata", ips);
try(FileWriter fileWriter =
    new FileWriter("newFileName.json") ){
    fileWriter.write(obj.toString());
}