String s = c.getText();
    double cIn = Double.parseDouble(s);
    double fOut = ((1.8)*(cIn))+32;
    String s2 = f.getText();
    double fIn = Double.parseDouble(s2);
    double cOut = ((fIn-32)/1.8);