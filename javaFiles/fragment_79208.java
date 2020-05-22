int ctr;

if(semesterS.equals(semester[0]))
{
    selectedSubj = sem1AddSubjCB.getSelectedIndex();
    selectedSubjTime = sem1AddSubj[selectedSubj];

    for(ctr = 0; ctr <= sem1AddSubj.length; ctr++)
    {
        if(selectedSubjTime.equals(sem1AddSubjTime[ctr]))
        {
            JOptionPane.showMessageDialog(null, "Choosen Subject has same time with the others!", "Error", 0);

        }else{
            sem1AddSubjCB.getSelectedItem();

        }

    }

}else if(semesterS.equals(semester[1]))
{
    selectedSubj = sem2AddSubjCB.getSelectedIndex();
    selectedSubjTime = sem2AddSubj[selectedSubj];

    for(ctr = 0; ctr <= sem1AddSubj.length; ctr++)
    {

        if(selectedSubjTime.equals(sem2AddSubjTime[ctr]))
        {
            JOptionPane.showMessageDialog(null, "Choosen Subject has same time with the others!", "Error", 0);

        }else{
            sem2AddSubjCB.getSelectedItem();

        }
    }

}