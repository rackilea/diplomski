public void disableButtons(String[] buttonNames) {
    for (String name : buttonNames) {
        int id = getResources().getIdentifier(name, "id", getPackageName());
        Button button = (Button) findViewById(id);
        button.setEnabled(false);
    }
}