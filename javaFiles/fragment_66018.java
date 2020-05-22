public class MainActivity implements ResponseListener{

public void someMethod() {
 WebManager wm = new WebManager(); 
 //pass the activity as the listener
 wm.getObject1(this);

}
protected void onObject1DataDownload(JSONObject jsonObject) { 
//this method will be called }

protected void onObject2DataDownload(CUSTOMOBJECT obj) { //Do something with the data }

}