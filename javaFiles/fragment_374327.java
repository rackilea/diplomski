else if (e.getSource() == btnadd) {
        String s1 = new String(t1.getText());
        String s2 = new String(t2.getText());
        String s3 = new String();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);

        int c = a + b;
        s3 = String.valueOf(c);
        t3.setText(s3);
    }