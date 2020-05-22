try{
        String config2Location = config1Properties.getProperty("location");

        FileReader reader = new FileReader(config2Location);
        Properties config2Properties = new Properties();
        config2Properties.load(reader);
        String googURL = config2Properties.getProperty("URL");

        java.awt.Desktop.getDesktop().browse(java.net.URI.create(googURL));

        }
    catch(Exception ex){

        System.out.println(ex);
    }