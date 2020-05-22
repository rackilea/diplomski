Form hi = new Form("JSON Parsing", new BoxLayout(BoxLayout.Y_AXIS));
JSONParser json = new JSONParser();
try(Reader r = new InputStreamReader(Display.getInstance().getResourceAsStream(getClass(), "/anapioficeandfire.json"), "UTF-8")) {
    Map<String, Object> data = json.parseJSON(r);
    java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>)data.get("root"); 
    for(Map<String, Object> obj : content) { 
        String url = (String)obj.get("url");
        String name = (String)obj.get("name");
        java.util.List<String> titles =  (java.util.List<String>)obj.get("titles"); 
        if(name == null || name.length() == 0) {
            java.util.List<String> aliases = (java.util.List<String>)obj.get("aliases");
            if(aliases != null && aliases.size() > 0) {
                name = aliases.get(0);
            }
        }
        MultiButton mb = new MultiButton(name);
        if(titles != null && titles.size() > 0) {
            mb.setTextLine2(titles.get(0));
        }
        mb.addActionListener((e) -> Display.getInstance().execute(url));
        hi.add(mb);
    }
} catch(IOException err) {
    Log.e(err);
}
hi.show();