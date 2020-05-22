ActionListener listener = new ActionListener()  
        {  
            public void actionPerformed(ActionEvent e)  
            {  
                // Update the display with the time.
            }  
        }; 
timer = new Timer(speed, listener);
timer.setInitialDelay(pause);
timer.start();