@Override
public void actionPerformed(ActionEvent e) {
    switch (j) {
    case 0:
        frame.getContentPane().setBackground(Color.red);
        break;
    case 1:
        frame.getContentPane().setBackground(Color.yellow);
        break;
    case 2:
        frame.getContentPane().setBackground(Color.blue);
        break;
    default:
        frame.getContentPane().setBackground(Color.green);
        break;
    }
}