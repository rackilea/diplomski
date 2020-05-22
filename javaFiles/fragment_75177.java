if("switch".equals(action))
{           
    // ImageIcon sun = new ImageIcon("assets/sun.png");
    // ImageIcon moon = new ImageIcon("assets/moon.png");

    JButton btn = (JButton) ae.getSource();

    changeLunar();
    count++;
    if (count % 2 == 0)
    {
         btn.setIcon(sun);
    }
    else
    {
         btn.setIcon(moon);
    }