List<Component> list = getComponentsAsList(homePermssionsCheckBoxPanel);

for(Component c : list){
    if (!(c instanceof JCheckBox)) continue;
    if (((JCheckBox)c).isSelected()){
        // doStuff
    }
}