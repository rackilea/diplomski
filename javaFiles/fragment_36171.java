public void actionPerformed(ActionEvent e) {
            entry.vehicleSelected(); 
            if(e.getSource() instanceof JButton )
                ((JButton)e.getSource()).setBackground(Color.RED); 
                ((JButton)e.getSource()).setOpaque(true);
                ((JButton)e.getSource()).setContentAreaFilled(false);
                if (buttonToReset!=null) {
                    buttonToReset.setBackground(UIManager.getColor("Button.background"));
                }
                buttonToReset = ((JButton)e.getSource());
        }});