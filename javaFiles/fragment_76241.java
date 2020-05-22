public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
 Log.d("form","onitemselected");
 switch (parent.getId()) {
 case R.id.spinDimension:
 tvReadValue.setText("spinDimension" + position);
 Log.d("form","regionid:" + r.id);
 break;
 case R.id.speedDimension:
 tvReadValue.setText("speedDimension" + position);
 Log.d("form","state id:");
 break;
}