// Step 1 (Send data to edit.class)
Intent i = new Intent(this, Edit.class);
startActivityForResult(i, 1);

// Step 3 (Receive new data)
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 1) {
        if(resultCode == RESULT_OK) {
            String strEditText = data.getStringExtra("key");

           // update your listview in here with new data
        }     
    }
}