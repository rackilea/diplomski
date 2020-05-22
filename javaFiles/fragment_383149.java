List<String> output = new ArrayList<>();

    //FIll List with data
    for (String fileOrFilderName : changedFilesAndFolders) {
        output.add(fileOrFilderName);
    }

    //Output

    JList<String> list = new JList<>(new Vector<>(output));

    JOptionPane.showMessageDialog(null, new JScrollPane(list), "Edited or added files", JOptionPane.INFORMATION_MESSAGE);