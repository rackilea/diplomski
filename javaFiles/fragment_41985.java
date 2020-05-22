public class Menu {

    private final Hunger hunger; // Not initialized here but in the constructor
    private final Sleep sleep;   
    Scanner scanner = new Scanner(System.in);

    String answer;

    /**
     * Constructor that initializes the internal sleep and hunger
     * from values passed by whoever is creating and using it.
     *
     * @param hunger Hunger object passed from calling Human
     * @param sleep  Sleep object passed from calling Human
     */
    public Menu( Hunger hunger, Sleep sleep ) {
        this.hunger = hunger;
        this.sleep = sleep;
    }

    public void mainMenu(){
        System.out.println("Main menu: 1 Home, 2 Work, 3 Shop, 4 Nessecity");

        answer = scanner.next();

        if(answer.equals("1")){ 
            homeMenu();
        } else if(answer.equals("2")){
            workMenu();
        } else if(answer.equals("3")){
            shopMenu();
        } else if(answer.equals("4")){          
            hunger.printHunger();
            sleep.printSleep();
        }
    }
}