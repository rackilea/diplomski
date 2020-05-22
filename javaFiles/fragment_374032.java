for (final JButton currentButton : this.letterButtonsArray){
            this.buttonPanel.add(currentButton);    
            currentButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    currentButton.setVisible(false);

                    String temporaryString = currentButton.getText();

                    for(int i = 0; i < textFieldArray.size(); i++)
                      JTextField elem = textFieldArray.get(i);
                      if(elem.getText().equals("")){ // or if you don't want spaces do: elem.getText().trim().equals("");
                          elem.setText(temporaryString);
                          break;
                      }
                    }

                }

            });
        }