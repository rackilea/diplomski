public void onClickGreen(View view) {
    openActivity("com.iprex.green", "com.iprex.green.Green");
}

public void onClickYellow(View view) {
    openActivity("com.iprex.yellow", "com.iprex.yellow.Yellow");
}

public void onClickRed(View view) {
    openActivity("com.iprex.red", "com.iprex.red.Green");
}

public void onClickTBTWhite(View view){
    openActivity("com.iprex.tbtwhiten", "com.iprex.tbtwhite.TBTWhite");
}

private void openActivity(String packageName, String className) {
    Intent intent = new Intent();
    intent.setClassName(packageName, className);
    startActivity(intent);
}