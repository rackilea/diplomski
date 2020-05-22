private void resultActionPerformed(java.awt.event.ActionEvent evt) {
    StringBuilder message = new StringBuilder();                                   
    // TODO add your handling code here:
    if (pick1 > pick2) {
        message.append("The New President is Koon!\n");
    }
    else if (pick2 > pick1) {
        message.append("The New President is Baam!\n");
    }
    else if (pick1 == pick2) {
        message.append("The Result for the new President is a Tie! Please Vote Again.\n");
    }
    if (pick3 > pick4) {
        message.append("The New VP is Sachi!\n");
    }
    else if (pick4 > pick3) {
        message.append("The New VP is Faker!\n");
    }

    resultstf.setText(message.toString());
}