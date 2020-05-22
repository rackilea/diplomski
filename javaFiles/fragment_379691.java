for(int i = 0; i<fList.length; i++){
        JTextField field= new JTextField("field: "+fList[i]);
        add(new JLabel(fList[i]));
        add(field);
        fields.add(field);
}