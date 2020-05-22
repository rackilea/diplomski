public void actionPerformed(ActionEvent e) {
    value++;
    value %= 3;

    switch(value) {
    case 0:
        setIcon(null);
        break;
    case 1:
        setIcon(X);
        break;
    case 2:
        setIcon(O);
        break;
    default:
        break;
    }
}