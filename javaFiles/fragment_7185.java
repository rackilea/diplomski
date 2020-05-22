jComboBox1.addItemListener(new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent event) {
            if(event.getStateChange() == ItemEvent.SELECTED){
                Object o = event.getItem();
                Float floatValue = Float.valueOf(o.toString());
                System.out.println(floatValue);
            }
        }
});