@Override
public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();

    if (command.equals("Nuovo..")) {
        this.setContentPane(pannelloM);
        this.invalidate();
        this.validate();


    } else if (command.equals("Leggi..")) {

    } else if (command.equals("Elimina..")) {

    }
}