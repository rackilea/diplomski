/* Hi, Welcome to stack overflow.
     * The reason why you only see the button 2 is because it is overlapping one another.
     * I would suggest you to look through the layoutManager https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html and really get your hands dirty
     * There are many ways of getting your desired result, you can do it with GridBagLayout but i would suggest you create JPanel and make it as a container
     * The reason why you only see the button 2 is because it is overlapping one another 
     */

public static void main(String[] args){

    //Variable 
    JTextField field = new JTextField(10);
    JButton btn = new JButton("Enter");
    JTextArea area = new JTextArea(50,50);

    //-- Main frame
    JFrame frame = new JFrame("Testing");
    //IF you need a specific size , you can set your preferred size to your jframe
    //otherwise , you can just use frame.pack() at the end of the code 
    //frame.setSize(300,300);
    frame.setLayout(new BorderLayout());

    //-- Top Container
    JPanel topContainer = new JPanel();
    topContainer.setLayout(new FlowLayout());
    topContainer.add(field);
    topContainer.add(btn);

    // Now add your container to your main frame 
    frame.add(topContainer,BorderLayout.PAGE_START);
    frame.add(area,BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
}