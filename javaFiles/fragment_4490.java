private void setSelection(Combo combo, String query)
{
    String comboText = combo.getText();

    int index = comboText.indexOf(query);

    if(index != -1)
        combo.setSelection(new Point(index, index + query.length()));
}