private void formWindowOpened(java.awt.event.WindowEvent evt) {
        String line = null;
        DefaultTableModel dtm = (DefaultTableModel) PhoneBookTable.getModel();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                data = new Vector();// this is important
                StringTokenizer st1 = new StringTokenizer(line, "|");
                while (st1.hasMoreTokens()) {
                    String nextToken = st1.nextToken();
                    data.add(nextToken);
                    System.out.println(nextToken);

                }
                System.out.println(data);
                dtm.addRow(data);//add here 
                System.out.println(".................................");
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }