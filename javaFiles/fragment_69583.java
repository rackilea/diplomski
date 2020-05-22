@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    restauLV.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
            if (position == 0){
                Intent cal = new Intent(HopNow.this, caloocan.class);
                startActivity(cal);
            }
        }
    });

}