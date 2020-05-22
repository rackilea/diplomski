public class MyAwesomeClass extends ... {
    private int clickCount;

    //...

    a.addActionListener(new ActionListener() {
        //int _clicks;
        public void actionPerformed(ActionEvent eco){
            clickCount++;
        }
    });

    //...

    int delay = 10000;
    ActionListener taskPerformer = new ActionListener() {
        //int _clicks;

        public void actionPerformed(ActionEvent evt) {
            System.out.println("You clicked "+clickCount+" times! Woop");
            // It might be nicer to close the active window
            System.exit(0);    
        }
    };