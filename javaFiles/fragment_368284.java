//Here we would accept a more general interface in reality, such as IPlugin

public static void InitMain(final MainFrame f, final TestPlugin p) {

//Check what plugin we loaded, in reality this would be a list of different types, marked by their marker iface
if(p instanceof IStatePlugin) {
        //It's a state plugin, so hook it up... 
        JButton b = p.GetControl();
        //Assume since it is an IStatePlugin marker, that it has method UpdateState, add the event
       b.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                f.lblTest.setText(p.UpdateState());
            }    
        });

        //Add the button    
        f.btnPanel.add(b);
        f.btnPanel.validate();

        //...
    } 
}