LabelField title = new LabelField("Screen Title");
    title.setPadding(40, 0, 20, 60);

    VerticalFieldManager vfm = new VerticalFieldManager(USE_ALL_WIDTH);
    vfm.setBackground(BackgroundFactory.createSolidBackground(Color.BLUE));
    vfm.setPadding(20, 0, 20, 0);

    ButtonField btn1 = new ButtonField("Option 1");
    btn1.setPadding(2, 0, 3, 0);

    ButtonField btn2 = new ButtonField("Option 2");
    btn2.setPadding(2, 0, 3, 0);

    add(title);
    vfm.add(btn1);
    vfm.add(btn2);
    add(vfm);