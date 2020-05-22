@Override
        public void itemStateChanged(ItemEvent e) {

            if(e.getSource() instanceof JCheckBox)
            { 
                JCheckBox  checkBox = (JCheckBox)e.getSource();
                if(checkBox.getName().equals("expectedName"))
                          ; // do my thing
             }
        }