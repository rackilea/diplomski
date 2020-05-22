private void meanBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int sum = 0;

        for (String n : list) {
            sum += Integer.parseInt(n);
        }
        consoleTxt.append("The mean of the data set is  " + ((double) sum / list.length) + "\n");
    }