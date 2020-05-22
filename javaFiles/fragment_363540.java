else if (e.getActionCommand().equalsIgnoreCase("Copy"))
            {
                JTextArea a = new JTextArea();    // CREATING A NEW OBJECT
                a.setEditable(true);
                a.copy();
            }                // AS Soon as the code comes HERE THE Instance IS LOST with the data