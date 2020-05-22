String[] choices = {"1. Routines for Triangles", "2. Routines for Temperatures", 
                    "3. Routines for Geometric Figures", "4. String Manipulations",
                    "5. Miscellaneous Simple Games.", "6. Quit"};

String menu = "";
while (!menu.equals("6. Quit")) {
    menu = (String) JOptionPane.showInputDialog(null, "<html>Choose A Menu Item:<br><br></html>", "Main Menu", 
                    JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
    if (menu == null) {
        //continue; //uncomment and delete line below to force menu item 6 to be selected to quit Main Menu.
        break; //Quit the Main Menu
    }

    switch (menu) {
        case "1. Routines for Triangles":
            triangleRoutines();  //one sub menu
            break;
        case "2. Routines for Temperatures":
            break;
        case "3. Routines for Geometric Figures":
            break;
        case "4. String Manipulations":
            break;
        case "5. Miscellaneous Simple Games.":
            break;
        case "6. Quit":
            // This case is not really required unless you want to
            // do some cleanup of sorts before quiting. 
            break;
        }
    }