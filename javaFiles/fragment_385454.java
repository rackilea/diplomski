for (int i = 1; i <= splitter.length; i++) {
    Button button = (Button) findViewById(getResources().getIdentifier("button" + i, "id",
            this.getPackageName()));

    button.setText(spliter[i - 1]);
}