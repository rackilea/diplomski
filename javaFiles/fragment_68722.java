int f = showFrame(frame, controller);
  JPanel contentPane = (JPanel)displayFrames.get(f).getContentPane();
  contentPane.removeAll();
  contentPane.setLayout(new BorderLayout()); // just to be sure
  contentPane.add(headerPanel, BorderLayout.PAGE_START);
  contentPane.add(new EnterPINPanel(), BorderLayout.CENTER);
  contentPane.add(footerPanel, BorderLayout.PAGE_END);
  contentPane.revalidate(); // *** note that it's **re**validate
  contentPane.repaint();
  displayFrames.get(f).setVisible(true);