for(int i = 0; i < ar.size(); i++)
{
    JCheckBox checkbox = new JCheckBox();
    checkbox.setText(ar.get(i).toString());
    checkbox.setSelected(true);

    // add the checkbox to the ArrayList
    checkboxes.add(checkbox);
}