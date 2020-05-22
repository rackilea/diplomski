Timer timer = new Timer(750, new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(!solution.isEmpty()){

            Node current = solution.pop();
            moveBuilder(current);
            repaint();
        }


    }
});

timer.setRepeats(true);
timer.start();