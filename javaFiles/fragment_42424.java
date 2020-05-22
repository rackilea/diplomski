Button seçenekler = (Button) findViewById(R.id.seçenekler);
    seçenekler.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            // view infalted
            popupView = layoutInflater.inflate(R.layout.pop_up, null);