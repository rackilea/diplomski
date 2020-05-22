ActionListener countDown=new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        timeLeft -= 100;
        SimpleDateFormat df=new SimpleDateFormat("mm:ss:S");
        jLabel1.setText(df.format(timeLeft));
        if(timeLeft<=0)
        {
            timer.stop();
        }
    }
};
Timer timer=new Timer(100, countdown);