private void voteActionPerformed(java.awt.event.ActionEvent evt) {                                     
    // TODO add your handling code here:

    if (koonchk.isSelected()){
        pick1++; //Change to pick[1]++
//    koontf.setText(Integer.toString(pick1)); remove
    }
    else if (baamchk.isSelected()){
        pick2++; //change to pick[2]++
//    baamtf.setText(Integer.toString(pick2)); remove
    }
    if(sachichk.isSelected()){
        pick3++; //change to pick[3]++
//    sachitf.setText(Integer.toString(pick3)); remove
    } 
    else if (fakerchk.isSelected()){
        pick4++; //Change to pick[4]++
//    fakertf.setText(Integer.toString(pick4)); remove
    }
    if (phonsekalchk.isSelected()){
        pick5++; //Change to pick[5]++
//    phonsekaltf.setText(Integer.toString(pick5)); remove
    }
    else if (laurechk.isSelected()){
        pick6++; //Change to pick[6]++
//    lauretf.setText(Integer.toString(pick6)); remove
    }
    if (yeonchk.isSelected()){
        pick7++; //Change to pick[7]++
//    yeontf.setText(Integer.toString(pick7)); remove
    }
    else if (aguerochk.isSelected()){
        pick8++; //Change to pick[8]++
//    aguerotf.setText(Integer.toString(pick8)); remove
    }
    else if (agnischk.isSelected()){
        pick9++; //Change to pick[9]++
    //agnistf.setText(Integer.toString(pick9)); remove
    }
    if (lokichk.isSelected()){
        pick10++; //Change to pick[10]++
    //lokitf.setText(Integer.toString(pick10)); remove
    }
    else if (lawlietchk.isSelected()){
        pick11++; //Change to pick[11]++
    //lawliettf.setText(Integer.toString(pick11)); remove
    }
    else if (ryuzakichk.isSelected()){
        pick12++; //Change to pick[12]++
    //ryuzakitf.setText(Integer.toString(pick12)); remove
    }
    updateTextFields(); //Add this new line.
}