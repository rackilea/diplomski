public Settings() {
        initComponents();
        try {
            Scanner sc = new Scanner(new FileInputStream("settings.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("sample=")) {
                    text = line.replaceFirst("sample=", "");
                } 
            }
            jTextField1.setText(text);
            sc.close();
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
            return;
        }
    }