public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==startButton) {
       Start myStart = new Start();
       myStart.foo();
    }
}