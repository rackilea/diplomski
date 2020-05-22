String newtype_mod="";
String newcontent_mod="";

if ((object.has("message"))) 
{
     JSONObject message = object.getJSONObject("message");
     newtype_mod = object.getJSONObject("message")
                        .getString("type");
     newcontent_mod = object.getJSONObject("message")
                     .getString("content");
     objSample = new GetSetMethod();
     objSample.setnewcontent_mod(newcontent_mod);        
     objSample.setnewtype_mod(newtype_mod);
     Log.v("##"+newcontent_mod,"V "+newtype_mod);
}