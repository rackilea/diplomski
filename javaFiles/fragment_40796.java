button102 = (Button) findViewById(R.id.button1002);
button102.setEnabled(true);
switch(view.getId()) {
    case R.id.checkBox1:
        checkBox1.setChecked(true);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        break;
    case R.id.checkBox2:
        checkBox3.setChecked(false);
        checkBox2.setChecked(true);
        checkBox1.setChecked(false);
        break;
    case R.id.checkBox3:
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(true);
        break;
}