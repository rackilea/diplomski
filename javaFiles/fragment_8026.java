public JFrameExt() {
    main = new JFrame();
    tl1 = new TextListener();
    ts1 = new TextSource();

    main.setLayout(new FlowLayout());

    main.add(tl1);
    main.add(ts1);

    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main.pack();
    main.setLocationRelativeTo(null);
    main.setVisible(true);
}