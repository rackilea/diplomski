@Override
public void afterTextChanged(Editable s) {

  if(editabletext.length() == 8){
    editabletext = editabletext.substring(0, 4) + "-" + editabletext.substring(4);

    //or you could use a regex:

    editabletext = editabletext.replaceAll("([0-9]{4})([0-9]{4})", "$1-$2")
  }
}