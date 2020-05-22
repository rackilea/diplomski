public void actionPerformed(ActionEvent e) {
            Subtraction subtraction = new Subtraction();
            subtraction.frmSubtraction.setVisible(true);
            frmSubDimensions.setVisible(false);

            switch(comboBoxA.getSelectedItem().toString()){
                case "3x1":{
                    subtraction.x3Visibility(true);
                    break;}
                /*case "4x1":
                    lblX4.setEnabled(true);
                    break;*/
                default:{
                    subtraction.x3Visibility(false);
                    break;}
            }
        }