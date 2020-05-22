@SuppressLint("NewApi")
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.showlist_ehr);

...

...

    View.OnClickListener myBtnListener= new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(listView.getCheckedItemPosition() >= 0) {
               //get the object
               Cursor selectedCursor = (Cursor) listView.getItemAtPosition(listView.getCheckedItemPosition());

               switch(view.getId()){
                   case R.id.show_btn:
                       //show selectedCursor details
                       break;
                   case R.id.delete_btn:
                       String stid = selectedCursor.getString(0);
                       //change the stud_id to your database field id name
                       String sql = "DELETE FROM Student WHERE stud_id = '" + stid + "'";
                       Cursor cursor = DBOperator.getInstance().execQuery(sql);
                       adapter.changeCursor(cursor);
                       break;
               }
           }
        }
    }

    showBtn.setOnClickListener(myBtnListener);
    deleteBtn.setOnClickListener(myBtnListener);
}