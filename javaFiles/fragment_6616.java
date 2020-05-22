public class MyClass {

public static void main(String[] args) {
    JButton send = new JButton();
    final BooleanWrapper click = new BooleanWrapper();

    click.value = false;

    send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                click.value = true;
            }
        });

    send.getActionListeners()[0].actionPerformed(new ActionEvent(new MyClass(), 1, "very bad idea"));

    if (click.value ){
            System.out.println("WORKS GOOD!!");
    }

}

private static class BooleanWrapper
{
    private Boolean value;
}