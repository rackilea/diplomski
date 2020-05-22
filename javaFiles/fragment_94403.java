String sex = null;
...

onCheckedChanged(RadioGroup arg0, int selectedId){
  if(selectedId == R.id.femaleselected){
     sex = "female";
  } else {
     sex = "male";
  }
}