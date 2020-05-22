public class MenuSpinner extends Spinner {

   public MenuSpinner(Context context) {
      super(context);
      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.comboCasino, android.R.layout.simple_spinner_item);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      setAdapter(adapter);
      setSelection(0, false);   
      .
      .
      .
   }
}