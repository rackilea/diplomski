tv.getBackgroundDrawable().setColorFilter(0xFFff6347, Mode.MULTIPLY);
tv.invalidate();
tv.addTextChangedListener(new TextWatcher() {

   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               tv.getBackgroundDrawable().setColorFilter(null);
               tv.invalidate();
   }