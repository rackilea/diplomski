private void createJButton (int numOfBotons)
        {
            int x=20, y=300, width=40, height=50; //choose whatever you want
            JRadioButton[] jRadioButton = new JRadioButton[numOfBotons];
            for(int i=0; i<numOfBotons; i++, y-=20) 
            {
                jRadioButton[i] = new JRadioButton(""+i);
                jRadioButton[i].setBounds(x, y, width, height);
                group.add(jRadioButton[i]);
                frame.add(jRadioButton[i]);

            }

        }