public class coreTuts{


//Do a toast notification
public void sampleToast(Context context)
{

    Toast toast = Toast.makeText(context,
            "This is a message displayed in a Toast",
            Toast.LENGTH_SHORT);

    toast.show();
}

}