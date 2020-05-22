while(answer!=-33)
    {
        if (answer == 1)
        {
            votescount[0] = votescount[0]+1;
        }
        else if (answer == 2)
        {
            votescount[1] = votescount[1]+1;
        }
        else if (answer == 3)
        {
            votescount[2] = votescount[2]+1;
        }
        else if (answer == 4)
        {
            votescount[3] = votescount[3]+1;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Vote for one of these four paintings!");
        }
        JOptionPane.showMessageDialog
        (null, "The current votes are" + "\n" +
        votescount[0] + " :" + painting[0] + "\n" +
        votescount[1] + " :" + painting[1] + "\n" + 
        votescount[2] + " :" + painting[2] + "\n" +
        votescount[3] + " :" + painting[3]);

        userinput = JOptionPane.showInputDialog
        ("Please tell us which painting you think is the best."+"\n"+
        "Vote 1 "+painting[0]+"\n"+
        "Vote 2 "+painting[1]+"\n"+
        "Vote 3 "+painting[2]+"\n"+
        "Vote 4 "+painting[3]);

        answer = Integer.parseInt(userinput);
   }//ENDS LOOP