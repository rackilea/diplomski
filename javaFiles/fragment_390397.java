JButton[] blackButtons = new JButton[4 * 8];
JButton[] whiteButtons = new JButton[4 * 8];

for(int i = 0; i < blackButtons.length; i++)
{
    blackButtons[i] = new JButton("B");
    blackButtons[i].setBackground(Color.BLACK);
}
for(int i = 0; i < whiteButtons.length; i++)
{
    whiteButtons[i] = new JButton("W");
    whiteButtons[i].setBackground(Color.WHITE);
}