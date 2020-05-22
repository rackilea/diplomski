boolean listContains(List<TextView> txtViews, String textToCheck) {
    for (TextView txtView : txtViews) {
        if (txtView.getText().toString.contains(textToCheck)) {
            return true;
        }
    }
    return false;
}