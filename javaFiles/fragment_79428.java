Properties propss = new Properties();
            OutputStream output = null;

            try {

                output = new FileOutputStream("server.properties");

                // set the properties value
                  props.setProperty("name", addressForm.getName());
                  props.setProperty("address", addressForm.getAddress());

                // save properties to project root folder
                props.store(output, null);                  

            } catch (IOException io) {
                io.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }