JTextField tf = new JTextField();
    TextFieldStreamer ts = new TextFieldStreamer(tf);
    //maybe this next line should be done in the TextFieldStreamer ctor
    //but that would cause a "leak a this from the ctor" warning
    tf.addActionListener(ts);

    System.setIn(ts);