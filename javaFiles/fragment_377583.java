btnSubmit.addActionListener(new ActionListener()
        {

                @Override
                public void actionPerformed(ActionEvent arg0)
                {
                    final String data = txtrConfirm.getText();
                    if( data.compareTo("1234") != 0 )
                    {
                        // alert the user
                    }
                    else
                    {
                        // data is good, do something with it
                    }
                }

        });