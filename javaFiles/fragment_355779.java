public class Shop1 implements ActionListener{

    private int alis;

    public void actionPerformed(ActionEvent event){
        alis++; // the variable is defined in the classes scope, so the values is "kept"
        System.out.println(alis);
    }

}