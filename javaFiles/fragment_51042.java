for(int i = 0; i < appList.size(); i++) { 

    final int _i = i;

    btn.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // use _i instead of i
        }
    });
}