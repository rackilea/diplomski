public void onClick(View v) {
  ((CheckBox)v).setChecked (false);
  v.setEnabled (false);
  buyU asyncTask = new buyU();
  asyncTask.execute("value1");
}