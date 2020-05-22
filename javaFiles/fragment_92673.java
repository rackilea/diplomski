public static class DatePickerFragment extends DialogFragment
    implements DatePickerDialog.OnDateSetListener 
    {
    Callback callback;
    public void setCallback(Callback callback){
        this.callback = callback;
    }