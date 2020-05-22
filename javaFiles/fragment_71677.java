if (cmd.equals(AdminCommands[1])) {
        String playerUsername = scanner.next();
        int cashTransfer = scanner.nextInt();

        File folder = new File(playerUsername);
        File pFile = new File(folder, playerUsername + ".txt");
        File bFile = new File(folder, "balance.txt");
        if (pFile.exists()) {
            try {
                Account pAcc = new Account(playerUsername, cashTransfer);
                FileWriter bWriter = new FileWriter(bFile);
                BufferedWriter writer;
                writer = new BufferedWriter(bWriter);
                writer.write(""+cashTransfer);
                pAcc.SaveInfo();
                writer.close();
                LabelInfo.setText("Money transfer complited ! ( $" + cashTransfer + " ) to ( " + pAcc.username + " )");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "ERROR: Can't save balance !");
            }
        } else {
            LabelInfo.setText("Player not found !");
        }
    }