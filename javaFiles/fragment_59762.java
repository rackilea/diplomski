Image image;

      Insets insets;

      JLabel label = new JLabel("asd");

      public TestCls() {
        super();
        setLayout(new FlowLayout());

        ImageIcon icon = new ImageIcon(TestCls.class.getClassLoader().getResource("user_images/smile/smile.png"));
        image = icon.getImage();
        image = createImage(new FilteredImageSource(image.getSource(),
            new CropImageFilter(1, 1, 15, 15)));

        label.setIcon(new ImageIcon(image));
        add(label);
      }

      public static void main(String args[]) {
        JFrame f = new TestCls();
        f.setSize(200, 200);
        f.show();
      }