private Configuration() {
        ini = new Wini();
        try {
            stream = new FileInputStream(Constants.PATH);
            ini.load(stream);
        }
        catch (Exception e) {
            System.out.println("FILE NOT FOUND!");
        }
    }