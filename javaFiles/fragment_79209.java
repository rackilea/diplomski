int ctr;

if(semesterS.equals(semester[0]))
{
    selectedSubj = sem1AddSubjCB.getSelectedIndex()-1;
    selectedSubjTime = sem1AddSubjTime[selectedSubj];

    for(ctr = 0; ctr < sem1SubjTime.length; ctr++)
    {
        if(selectedSubjTime.equals(sem1SubjTime[ctr])) {
        JOptionPane.showMessageDialog(null, "Choosen Subject has same time with the others!", "Error", 0);
        } else {
        sem1AddSubjCB.getSelectedItem();
        }

    }

} else if(semesterS.equals(semester[1])) {
    selectedSubj = sem2AddSubjCB.getSelectedIndex()-1;
    selectedSubjTime = sem2AddSubjTime[selectedSubj];

    for(ctr = 0; ctr < sem2SubjTime.length; ctr++)
    {

        if(selectedSubjTime.equals(sem2SubjTime[ctr]))
        {
            JOptionPane.showMessageDialog(null, "Choosen Subject has same time with the others!", "Error", 0);
        } else {
            sem2AddSubjCB.getSelectedItem();
        }
    }
}