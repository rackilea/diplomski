public void paintComponents(Graphics g) {
   // Where's the super call???  All paint methods have a super
   // if you don't call it, expect really bad things to happen...
   if(speed <= 20)
    {
        speed++;
        // Don't do this
        repaint();
    }
    try
    {
        // NEVER, EVER do this, EVER
        Thread.sleep(speed);
    }
    catch(InterruptedException e){e.printStackTrace();}

    // These choices should be made else where.
    if(pos>=400)
    {
        b = false;
    }
    if(pos<=100)
    {
        b = true;
    }
    if(b==true)
    {
        pos = pos +5;
    }
    else
    {
        pos = pos -5;
    }
    // NEVER DO THIS IN A PAINT METHOD...
    repaint();