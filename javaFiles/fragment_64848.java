private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    String selected = (String) jList1.getSelectedValue();
    BufferedReader reader = null;
    BufferedWriter writer = null;
    try {
        File passwords = new File("/users/aak7133/desktop/passwords.txt");
        File temp = File.createTempFile("temp", ".txt", new File("/users/aak7133/desktop/"));
        reader = new BufferedReader(new FileReader(passwords));
        writer = new BufferedWriter(new FileWriter(temp));
        String line;
        System.out.println(selected);
        while ((line = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            // String trimmedLine = line.trim();

            if (line.contains(selected)) {
                continue;
            }
            writer.write(line + "\n");
        }
        if (passwords.canWrite()) {
            try {
                reader.close();
                reader = null;
            } catch (IOException ignore) {}

            try {
                writer.close();
                writer = null;
            } catch (IOException ignore) {}

            String path = passwords.getAbsolutePath();
            passwords.delete();
            boolean successful = temp.renameTo(new File(path));
            System.out.println(successful);

        }

    } catch (Exception e) {

    } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException ignore) {}
        }
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException ignore) {}
        }
    }
     updateList();
     clearFields();
}