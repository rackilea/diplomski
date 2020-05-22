RadioButton option_rdb1 = (RadioButton) findViewById(R.id.option_rdb1);
setOptions(0);

// if you used ArrayList<ArrayList<String>> optionslist
public void setOptions(int index){
if((index-1) <= optionsList.size()){
    ArrayList<String> temp = optionslist.get(index);
    options_rdb1.setText(temp.get(0).toString();
    options_rdb1.setText(temp.get(0).toString();
    options_rdb1.setText(temp.get(0).toString();
    options_rdb1.setText(temp.get(0).toString();
  }
}