DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String sTemp1 = "", sTemp2 = "";
        while ((sTemp1 = br.readLine()) != null) {
            sTemp2 = sTemp1;
        }
        in.close();

        textField.setText(sTemp2);