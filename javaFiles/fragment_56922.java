try {
        mf = new MaskFormatter("***.***.***.***");
        // You have txtIP declared as a class variable, and you (I believe the term is called shadowed) 
        // hid the class variable with your original code and txtIP is treated as a local variable in your constructor
        // so the class field was never initialized
        txtIP = new JFormattedTextField(mf);
        panIP.add(txtIP);
        txtIP.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        txtIP.setPreferredSize(new Dimension( 150, 24)); 
    } catch (ParseException pe) {
        e.printStackTrace();
    }