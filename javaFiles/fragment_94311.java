public void setDisplay(int index){
        jplType.add(jlblOptions);
        jplType.add(jtfOptions);
        jplType.setBorder(new TitledBorder(employeeTitles[index]));
        if(index == 0){
            jlblOptions.setText("Office:");
            jtfOptions.setText("");
        }
        else if(index == 1) {
            jlblOptions.setText("Air Time:");
            jtfOptions.setText("0");
            JCheckBox jcbCaptain = new JCheckBox("Is a Captain");
            jplType.add(jcbCaptain);
        }
        else if(index == 2){
            jlblOptions.setText("Air Time:");
            jtfOptions.setText("0");
        } 
        else
        {
            jlblOptions.setText("");
            jtfOptions.setText("");
        }
        add(jplType, BorderLayout.CENTER);

     }