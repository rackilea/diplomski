@Override
public void onOkay(ArrayList<Integer> selected) {
    StringBuilder stringBuilder = new StringBuilder();
    if (selected.size() != 0) {
        for (int i = 0; i < selected.size(); i++) {
            String categories = selectedArray[selected.get(i)];
            stringBuilder = stringBuilder.append(" " + categories);
        }
        Toast.makeText(this, "You have selected: "
                + stringBuilder.toString(), Toast.LENGTH_SHORT).show();
    }
}