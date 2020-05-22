import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.android.*;
import com.facebook.android.Facebook.DialogListener;

public class FacebookActivity extends Activity implements DialogListener,
        OnClickListener
{

    private Facebook facebookClient;
    private LinearLayout facebookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.test);//my layout xml

        facebookButton = (LinearLayout)this.findViewById(R.id.Test_Facebook_Layout);

    }

    @Override
    public void onComplete(Bundle values)
    {

        if (values.isEmpty())
        {
            //"skip" clicked ?
            return;
        }

        // if facebookClient.authorize(...) was successful, this runs
        // this also runs after successful post
        // after posting, "post_id" is added to the values bundle
        // I use that to differentiate between a call from
        // faceBook.authorize(...) and a call from a successful post
        // is there a better way of doing this?
        if (!values.containsKey("post_id"))
        {
            try
            {
                Bundle parameters = new Bundle();
                parameters.putString("message", "this is a test");// the message to post to the wall
                facebookClient.dialog(this, "stream.publish", parameters, this);// "stream.publish" is an API call
            }
            catch (Exception e)
            {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void onError(DialogError e)
    {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void onFacebookError(FacebookError e)
    {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void onCancel()
    {
    }

    @Override
    public void onClick(View v)
    {
        if (v == facebookButton)
        {
            facebookClient = new Facebook();
            // replace APP_API_ID with your own
            facebookClient.authorize(this, APP_API_ID,
                new String[] {"publish_stream", "read_stream", "offline_access"}, this);
        }
    }
}