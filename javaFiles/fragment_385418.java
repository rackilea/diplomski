if(table.getValueAt(row, 4)!=null)
    {
        Object ob = table.getValueAt(row, 4);
        String link_string=ob.toString();

        try {
            final URI uri = new URI("http://www.roseindia.net");
            System.out.println(".....................");

            ((AbstractButton) ob).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Desktop.isDesktopSupported()) {
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            desktop.browse(uri);
                            //button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            // desktop.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        } catch (Exception ex) {
                        }
                    }
                }
            });
        } catch (URISyntaxException e1) {
           e1.printStackTrace();
        }
    }