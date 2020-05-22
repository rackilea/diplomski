@Override
public void actionPerformed(ActionEvent e) {
        for(Component c : frame.getContentPane().getComponents()){
            if(c instanceof JPanel){
                frame.remove(c);
            }
        }
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setBounds(215, 2, 480, 480);
        frame.add(panel);
        frame.revalidate(); 
        frame.repaint(); 

    }