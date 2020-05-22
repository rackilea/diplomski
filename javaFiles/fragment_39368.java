**EDIT: Add of Source**

// Activity which calls the datepicker. I KNOW THAT THE CODE CAN BE IMPROVED! Just for trials.
public class MyActivity extends Activity
{
    /*
    * Code blabla
    */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {

            DialogFragment newFragment = new SettingsDatePicker();
            newFragment.setCallback(this);
            newFragment.show(getFragmentManager(), "Select the date");

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void CallBack(String text)
    {
            // i think this is called only the second time
            selectedDateView.setText(String.format("Selected Date: %s", text));
    }

    /*
    * Code blabla
    */
}


// DialogFragment
public class SettingsDatePicker extends DialogFragment
{

    private MyActivity activity = null;
    /*
    * Code blabla
    */
    public void setCallback(MyActivity activity) {
        //set callback class
        this.activity = activity;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        this.activity.CallBack("TextToUpdate");
    }

    /*
    * Code blabla
    */
}