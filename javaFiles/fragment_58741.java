String ok = "OptionPane.okButtonText";
    String text = ""; 
    text += " LAF: " + UIManager.getLookAndFeelDefaults().get(ok);
    text += " lookup: " + UIManager.get(ok);
    text += " default: " + UIManager.getDefaults().get(ok);
    System.out.println(text);

    // output, whereever I add that:
     LAF: OK lookup: OK default: OK