OutputStream out = null;
        try {

            Properties props = new Properties();

            File f = new File("myApp.properties");
            if(f.exists()){

                props.load(new FileReader(f));
                //Change your values here
                props.setProperty("ServerAddress", "ThatNewCoolValue");
            }
            else{

                //Set default values?
                props.setProperty("ServerAddress", "DullDefault");
                props.setProperty("ServerPort", "8080");
                props.setProperty("ThreadCount", "456");

                f.createNewFile();
            }



            out = new FileOutputStream( f );
            props.store(out, "This is an optional header comment string");

            System.out.println(props.get("ServerPort"));

       }
        catch (Exception e ) {
            e.printStackTrace();
        }
        finally{

            if(out != null){

                try {

                    out.close();
                } 
                catch (IOException ex) {

                    System.out.println("IOException: Could not close myApp.properties output stream; " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }