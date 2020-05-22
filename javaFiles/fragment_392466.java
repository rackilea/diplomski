public class LauncherUI extends Activity implements GuiServiceBridgeItf{

     ....
    @Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

            // register Activity to Application    
            GuiServiceBridgeItf gts = this;     
    mApplicationApp = (MyApplication)mContext.getApplicationContext();
    mApplicationApp .gsb = gts;

            ....
   }

   ....

    @Override
protected void onDestroy() {
   super.onDestroy();
       ....
       // Unregister Activity to prevent to Service to talk with   
       mMyApplication.gsb = null;
}

}