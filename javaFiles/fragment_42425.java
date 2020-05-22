Button seçenekler = (Button) findViewById(R.id.seçenekler);
      seçenekler.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            // view infalted
            popupView = layoutInflater.inflate(R.layout.pop_up, null);
           Button kaydet = (Button) popupView.findViewById(R.id.ayrintilar_kaydet);
           .... // rest of the code for button listener
           kaydet.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            popupWindow.showAsDropDown(layout_MainMenu);
            popupWindow.dismiss();
            layout_MainMenu.getForeground().setAlpha(0);
        }
    });