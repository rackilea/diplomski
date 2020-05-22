String addText = "NAME\t\tADDRESS\t\tTEL.No\tEMAIL\n";
        for (int i = 0; i < addressBookSize; i++) {
           addText = addText+entry[i].viewAllInfo();
        }
        System.out.print(addText);
 JOptionPane.showMessageDialog(null, new JTextArea(addText));