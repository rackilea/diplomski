for ( int  i = 0; i < Main.ipList.length; i++){
    JButton btn = new JButton();
    btn.setText(Main.ipList[i]);
    panel.add(btn);
    final int j = i;
    btn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Main.refreshSpecificIp(j);
            System.out.println("Bu");
        }   
    });
}