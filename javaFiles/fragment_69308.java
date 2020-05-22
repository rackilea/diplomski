SpringApplication.run(MyClass.class, args);
System.setProperty("java.awt.headless", "false");
SwingUtilities.invokeLater(() -> {
    JFrame f = new JFrame("myframe");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
});