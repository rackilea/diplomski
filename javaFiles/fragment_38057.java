Calendar facebook_check_post_date = Calendar.getInstance();
facebook_check_post_date.add(Calendar.DAY_OF_MONTH, -4);
long facebook_check_post_Unix_Time = facebook_check_post_date.getTimeInMillis() / 1000;    
String query = "SELECT message,timeline_visibility, created_time FROM stream WHERE source_id =     187050104663230 AND message AND strlen(attachment.fb_object_type) < 1 AND type != 56 AND type = 46      AND strpos(message, \"prayer time(s)\") < 0 AND strpos(message, \"White days\") < 0 AND     strpos(message, \"Hadith of the Day:\") < 0 AND created_time > " + facebook_check_post_Unix_Time + "LIMIT 1";

try 
{
    List<JsonObject> queryResults = facebookClient.executeFqlQuery(query, JsonObject.class);
    facebook_post = queryResults.get(0).getString("message");
    facebook_post_visibility = queryResults.get(0).getString("timeline_visibility");
    facebook_Label_visible = true;
    facebook_created_time_calendar.setTimeInMillis(queryResults.get(0).getLong("created_time")* 1000);
    out.print("Comment posted on:"); 
    out.println(facebook_created_time_calendar.getTime());
}
catch (Exception e)    {
    Logger.getLogger(JavaFXApplication4.class.getName()).log(Level.SEVERE, null, e);
}  

query = "SELECT fan_count FROM page WHERE page_id = 187050104663230";
try 
{
    List<JsonObject> queryResults = facebookClient.executeFqlQuery(query, JsonObject.class);
    facebook_Fan_Count = queryResults.get(0).getString("fan_count");
    out.println(facebook_Fan_Count);
}
catch (Exception e){
    Logger.getLogger(JavaFXApplication4.class.getName()).log(Level.SEVERE, null, e);
}