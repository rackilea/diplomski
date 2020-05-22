String parseThis;
 do {
     parseThis = JOptionPane.showInputDialog(null, "Please enter the number of cards you want dealt...");
    } while (parseThis == "");

 if (parseThis == null)
    break;

 numCardsDealt = Integer.parseInt(parseThis);