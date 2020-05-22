public static void main(String[] args) {

    Scanner command = new Scanner(System.in);

    System.out.println("Enter command: ");
    boolean running = true;

    while(running){

        switch(command.nextLine()){

        case "start":
            System.out.println("Machine started!");
            break;

        case "stop":
            System.out.println("Machine stopped.");
            break;

        case "exit":
            System.out.println("Application Closed");
            running = false;
            break;

        default:
            System.out.println("Command not recognized!");
            break;
        }
    }
    command.close();
}