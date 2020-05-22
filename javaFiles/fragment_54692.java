final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this,R.style.MyDialogTheme)
        .setCustomTitle(custom_dialog_header)
        .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int selectedIndex) {
                int selectedItem = selectedIndex;
            }
        })
        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int linkID) {
                String[] files = links.split(",");
            }
        })
        .setNegativeButton("Cancel", null)
        .create();
dialog.setOnShowListener(new DialogInterface.OnShowListener() {
    @Override
    public void onShow(DialogInterface d) {
        // to change background of positive button
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.some_color));
        // to change background of button area
        ButtonBarLayout b = (ButtonBarLayout)(dialog.getButton(AlertDialog.BUTTON_POSITIVE).getParent());
        b.setBackgroundColor(getResources().getColor(R.color.some_color));
    }
});
dialog.show();