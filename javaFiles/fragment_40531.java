JSONArray buttons = new JSONArray();

JSONObject button1 = new JSONObject();
button1.put("type", "web_url");
button1.put("url", "https://google.com");
button1.put("title", "show website");
buttons.put(button1);

JSONObject button2 = new JSONObject();
button2.put("payload", "postback");
button2.put("url", "Sample_PAYLOAD");
button2.put("title", "Start Chatting");
buttons.put(button2);