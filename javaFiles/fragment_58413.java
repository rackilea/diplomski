btnClosePopUp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        popupWindow.dismiss();
        Bel.setVisibility(View.VISIBLE);
        Phone.setVisibility(View.VISIBLE);
        dim_layout.setVisibility(View.INVISIBLE);                
    }
});