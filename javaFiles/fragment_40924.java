JPanel myPanel=new JPanel();
myPanel.setLayout(new GridLayout(Button_array.length-1,1))
for(int i = 0; i < buy.length; i++){
    buy[i] = new JButton("Buy");
    _myPanel.add(buy[i]);
}
_panel.add(myPanel,BorderLayout.EAST)