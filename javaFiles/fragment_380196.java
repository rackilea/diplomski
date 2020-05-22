ActionListener black = new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        JButton b1 = (JButton)source;
        b1.setBackground(Color.BLACK);
    }
};

for(int y=0; y<length; y++){
        for(int x=0; x<width; x++){
            grid[x][y]=new JButton();
            grid[x][y].setBackground(Color.WHITE);
            panel1.add(grid[x][y]);
            grid[x][y].addActionListener(black);
         }
}