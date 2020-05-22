final JFrame f = new JFrame();
    f.setContentPane(contentPane);
    f.setSize(800, 600);
    //        f.pack(); 

    JFrame controller = new JFrame("opener");
    controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Action open = new AbstractAction("open/hide second") {

        @Override
        public void actionPerformed(ActionEvent e) {
            f.setVisible(!f.isVisible());
        }

    };
    controller.add(new JButton(open));
    controller.pack();
    controller.setVisible(true);