List<String> strings = new ArrayList<String>();
        try {
            String line = null;
            while ((line = input.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error, file " + filePath + " didn't exist.");
        } finally {
            input.close();
        }

        String[] lineArray = strings.toArray(new String[]{});
        final DefaultComboBoxModel model = new DefaultComboBoxModel(lineArray);
        final JComboBox comboBox = new JComboBox(model);