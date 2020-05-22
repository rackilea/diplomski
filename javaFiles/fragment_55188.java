JSONParser parser = new JSONParser();
Object obj = parser.parse(new FileReader("C:\\myfile.json"));
JSONObject jsonObject =  (JSONObject) json;
JSONObject command= (JSONObject) jsonObject.get("command");
System.out.println("command: " + command);
long cancel= (Long) command.get("cancel");
System.out.println("cancel: " + cancel);