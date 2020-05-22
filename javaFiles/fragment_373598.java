ListPopupWindow listPopupWindow;
setUpListpopupWindow();
btnOpenMenu.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        listPopupWindow.show();
    } 
});