setLayout (new BorderLayout()); // asign layout to JFrame

add(label1,BorderLayout.PAGE_START); //Add JLabel 1 to Jframe

add(label2,BorderLayout.CENTER); //Add JLabel 2 to Jframe

 name = new JLabel("<html><ul>My name is : Erik  Landaverde "
            + "<li/>Some facts about myself: </li> "
            + "<li/>I was born and raised in South Central Los Angeles</li>"
            + "<li/>Have a Salvadorean background</li>"
            + "<li/>My favorite sport is soccer</li>"
            + "<li/>Lastly... I am a programmer!</li></ul></html>", SwingConstants.CENTER);

add(name,BorderLayout.PAGE_END); //Add JLabel 3 to Jframe