public class Gui extends JFrame implements ActionListener{
    private Validate validate;
    public Gui(Validate validate){
        super();
        this.validate = validate;
        //rest of the constructor.
    }
    ...
}

    public class Main{

        public static void main(String[] args) {
            Validate validate = new Validate();
            Gui gui = new Gui(validate);
        }
    }