FileInputStream fis = new FileInputStream("myFile");
        ObjectInputStream ois = new ObjectInputStream(fis);
        while(fis.available() > 0) {
            try {
                Object rper = ois.readObject();
                JOptionPane.showMessageDialog(null, "People:" + rper, "Saved Persons", JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ois.close();