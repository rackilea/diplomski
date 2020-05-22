JFrame frame = new JFrame("GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new MainPane());
            frame.setJMenuBar(myMenuBar);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);