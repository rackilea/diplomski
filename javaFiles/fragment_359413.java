class Whatever extends Activity {

    private TextView mTextView;
    private MyPassThroughListener mPassThroughListener = new MyPassThroughListener() {
           @Override
           public function passThrough(ObjectDay objDay) {
                  mTextView.setText(objDay.getSummary());    
           }
    }

    protected void onCreate(Bundle savedInstanceState) {
        ....
        buttonCreateExercise.setOnClickListener(new OnClickListenerCreateExercise(mPassThroughListener ));


    }

}

class OnLongClickListenerEditSummary {
   MyPassThroughListener mPassThroughListener;
   ...

   public OnLongClickListenerEditSummary (MyPassThroughListener passThroughListener) {
       mPassThroughListener = passThroughListener;
   }

   @Override
   public boolean onLongClick(View view) {
      ....

       new AlertDialog.Builder(context)
            .setPositiveButton("Save Changes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            ObjectDay objectDay = new ObjectDay();
                            objectDay.setId(dayId);
                            objectDay.setDayName(dName);
                            objectDay.setSummary(editTextSummary.getText().toString());

                            mPassThroughListener.passThrough(objectDay);

                            dialog.dismiss();
                        }

     ...
}