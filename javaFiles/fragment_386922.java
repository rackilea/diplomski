private void addEntityRefs(Map<String, String> icns, File xml) {
    Scanner reader = null;
    BufferedWriter writer = null;
    try {
        reader = new Scanner(xml, "utf-8");
        // standardOut.println("Reading " + xml.getName());
        // System.out.println();
        int count = 0;
        File targetFile = new File(xml.getParentFile(), "out2.xml");
        if (!targetFile.exists()) {
            boolean created = targetFile.createNewFile();
            System.out.println("File created: " + created);
        }
        writer = new BufferedWriter(new FileWriter(targetFile));

        while (reader.hasNextLine()) {
            count++;
            if (count == 1) {
                writer.append(reader.nextLine().replaceAll("\\s", " "));
            } else if (count == 2) {
                System.out.println("writing entities @ line 2");
                writer.append("\n<!DOCTYPE pm [\n");

                for (String item : icns.keySet()) {
                    item = item.trim();
                    writer.append("<!ENTITY " + item + " SYSTEM \"" + item + ".cgm\" NDATA cgm>\n");
                }
                writer.append("<!NOTATION cgm PUBLIC \"cgm\" \"\">\n]>\n");
            } else {
                System.out.println("Writing line " + count);
                writer.append(reader.nextLine().replaceAll("\\s", " ")).append("\r");
            }
        }
        // done writing
        writer.flush();

    } catch (FileNotFoundException ex) {
        Logger.getLogger(AARPdfGenUI.class.getName()).log(Level.WARN, null, ex);
        JOptionPane.showMessageDialog(this, ex, "File Not Found Exception", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
        Logger.getLogger(AARPdfGenUI.class.getName()).log(Level.WARN, null, ex);
        JOptionPane.showMessageDialog(this, ex, "IO Exception", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            reader.close();
        } catch (Exception e) {
            Logger.getLogger(AARPdfGenUI.class.getName()).log(Level.WARN, null, e);
            JOptionPane.showMessageDialog(this, e, "Exception", JOptionPane.ERROR_MESSAGE);
        }
        try {
            writer.close();
        } catch (Exception e) {
            Logger.getLogger(AARPdfGenUI.class.getName()).log(Level.WARN, null, e);
            JOptionPane.showMessageDialog(this, e, "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }
}