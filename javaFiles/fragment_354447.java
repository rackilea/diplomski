btnRemove.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Execute when button is pressed
            int row = table.getSelectedRow();
            int column = table.getSelectedColumn();
            if (row >= 0) {
                if (column >= 0) {
                    File file1 = new File("Activities.dat");
                    File temp = new File(file1.getAbsolutePath() + ".tmp"); // temp file
                    PrintWriter writer = null;
                    BufferedReader reader = null;
                    try {
                        writer = new PrintWriter(new BufferedWriter(new FileWriter(temp)), false);
                        reader = new BufferedReader(new FileReader(file1));
                        String lineToRemove = table.getValueAt(row, column).toString();
                        System.out.print(lineToRemove);
                        String currentLine;
                        while ((currentLine = reader.readLine()) != null) {
                            // trim newline when comparing with lineToRemove
                            String trimmedLine = currentLine.trim();
                            if (trimmedLine.equals(lineToRemove))
                                continue;
                            writer.println(currentLine);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ActivityScreen.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            if (reader != null)
                                reader.close();
                            if (writer != null) {
                                writer.flush();
                                writer.close();
                                file1.delete(); // delete the old one
                                temp.renameTo(file1); // make temp same as original
                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    table.setValueAt("", row, column);
                }
            }
        }
    });