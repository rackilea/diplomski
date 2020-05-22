public static void main(String[] args) {
        if (locateRegistry) {
            System.out.println("CLIENT USING LOCATE REGISTRY");
        } else {
            System.out.println("CLIENT USING NAMING");
        }

//        // Get ip address of server
        Scanner input = new Scanner(System.in);
        System.out.print("Client: Enter IP address of server: ");
        String ipAddress = input.nextLine();

        // Get port number
        System.out.print("Client: Enter port number: ");
        int portNumber = input.nextInt();
        // Create client
        BannerController client = new BannerController(ipAddress, portNumber);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }