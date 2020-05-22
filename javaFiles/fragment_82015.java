public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
        case "1":
        case "2":
        case "3":
        case "4":
        case "5":
        case "6":
        case "7":
        case "8":
        case "9":
        case "0":
        case ".":
            text += e.getActionCommand();
            break;
        case "=":
            break;
        case "Clear Last":
            text = text.substring(0, (text.length() - 1));
            break;
        case "Clear All":
            text = "";
            break;
        default:
            text = "";
            break;
    }
    display.setText(text);
}