public static void main(String[] args) throws IOException, EncoderException {

        /**
         * Define Object Storage Account information
         */
        String baseUrl = "https://tok02.objectstorage.softlayer.net/auth/v1.0/";
        String user = "set me";
        String password = "set me";
        Account account = new Account(baseUrl, user, password);
        // Define your container's name
        String containerName = "r";

        List<Container> containers = account.listAllContainers();
        for (Container container: containers){
            if(container.getName().contains(containerName))
            {
                System.out.println("Container: " + container.getName());
                for(ObjectFile file : container.listObjectFiles())
                {
                    System.out.println("File Name: " + file.getName());
                    System.out.println("Bytes: " + file.getBytes());
                    System.out.println("Meta Tags: " + file.getMetaTags());
                }
                System.out.println("==================================");
            }
        }
     }