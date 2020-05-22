public class Window extends JFrame
{
    ...

    // A java.util.List that stores all the buttons, so
    // that their icons may be changed later
    private List<JButton> buttons = new ArrayList<JButton>();

    // A java.util.List that stores all the ImageIcons that
    // may be placed on the buttons
    private List<ImageIcon> imageIcons = new ArrayList<ImageIcon>();

    public void addComponentsToPane(final Container pane)
    {
        ...

        for(int i = 0; i < countCard; i++;)
        {    
            // String concatenation is done with "+" in Java, not with "&"
            String fileName = "card" + i + ".png";

            // Create the icon and the button containing the icon  
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(fileName));
            JButton button = new JButton(imageIcon);

            // Add the button to the main panel
            compsToExperiment.add(button);

            // Store the button and the icon in the lists
            // for later retrieval
            imageIcons.add(imageIcon);
            buttons.add(button);

            // Attach an ActionListener to the button that will
            // be informed when the button was clicked.
            button.addActionListener(createActionListener(i));
        }
    }


    private ActionListener createActionListener(final int cardIndex) 
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                clickedCardButton(cardIndex);
            }
        };
    }

    private void clickedCardButton(int cardIndex)
    {
        System.out.println("Pressed button for card "+cardIndex);

        // Here you can change the icons of the buttons or so...
        JButton button = buttons.get(cardIndex);
        ImageIcon imageIcon = imageIcons.get(cardIndex);
        ....
    }