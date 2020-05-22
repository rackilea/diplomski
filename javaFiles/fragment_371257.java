while(true)
{
    int innerday=cal.get(Calendar.DAY_OF_MONTH);
    if(innerday!=day)
        break;
try {
    JSONObject json = new JSONObject(readUrl("url"));
    System.out.print(json.length());
    if(json.length()==3)
    {
        String type=(String) json.get("type");
        System.out.println(type);
        JSONObject crs=json.getJSONObject("crs");
        System.out.println(crs.toString());
        JSONArray features= (JSONArray) json.get("features");
        writer = new PrintWriter(new FileWriter(new File("filename"), true));
        for (Object object : features) {
            writer.write(object.toString());
        }
        writer.close();
    }

} catch (Exception e) {
    Thread.sleep(1000);
    continue;
}
Thread.sleep(180000);
}