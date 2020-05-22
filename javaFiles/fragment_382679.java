for (int rownum = 7 ; rownum >= 0 ; rownum--)
    {
    int number = rownum*8;
        if (rownum % 2 != 0)
        {
            for (int i = 7 ; i >= 0 ; i--)
            {
                a [i+number] = new JLabel (createImageIcon ((i+number) + ".jpg"));
                g.add (a [i+number]);
            }
        }
        else
        {
            for (int i = 0; i < 8; i++)
            {   
                a [i+number] = new JLabel (createImageIcon ((i+number) + ".jpg"));
                g.add (a [i+number]);
            }
        }
        }