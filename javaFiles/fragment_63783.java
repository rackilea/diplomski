public class PickDate_Dialog extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private EditText dateEditText;

    public PickDate_Dialog(EditText et){
        dateEditText = et;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){

        final Calendar c= Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        //Do you have a constructor for this? This is likely your issue

        return new PickDate_Dialog(getActivity(),this,year,month,day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {


        String date = day + "-"+(month+1)+"-"+year;
        if (dateEditText != null)
            dateEditText.setText(date);
    }

}