public void Traduciblocco(String abc){
    traduttore.traduci(abc, new Callback() {
        @Override 
        public void onCallback(String result) {
            // resultTxt.setText(result); 
        } 
    });
}