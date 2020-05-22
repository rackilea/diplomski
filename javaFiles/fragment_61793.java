JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        int result = JOptionPane.showConfirmDialog(null, "Exit?", "Confirm Exit",
                                JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.OK_OPTION)
                            System.exit(0);

                    }
                });