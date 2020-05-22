public class RoleAdminView extends Panel implements View{

 //add a button view 
 //
  @Override
public void uploadFailed(Upload.FailedEvent event) {
    Notification.show(event.getFilename() + "----" + event.getMIMEType());
    //here it will show the error if upload failed
}

@Override
public void uploadSucceeded(SucceededEvent event) {
/// do your functionlity
 }
  @Override
public OutputStream receiveUpload(String filename, String mimeType) {
   FileOutputStream fos = null;
   // do your functionality to save in any path or server path
    return fos; // Return the output stream to write to
 }

}