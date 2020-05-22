private void showRadioButtonDialog() {

 // custom dialog

  final Dialog dialog = new Dialog(this);
  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
  dialog.setContentView(R.layout.dialog_layout);
  List<String> stringList=new ArrayList<>();  // here is list
      for(int i=0;i<2;i++) {
          if (i==0){
              stringList.add("Number Mode");
          }else {
              stringList.add("Character Mode");
          }

      }

      RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.radioGroup);

      for(int i=0;i<stringList.size();i++){
            RadioButton rb=new RadioButton(this); // dynamically creating RadioButton and adding to RadioGroup.
            rb.setText(stringList.get(i));
            rg.addView(rb);
      }
}