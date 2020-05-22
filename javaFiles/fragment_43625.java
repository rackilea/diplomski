ActionListener listener = something;

for (int i = 65; i < 91; i++){
     JButton button = new JButton("<html><center>" + (char)i);
     button.addActionListener( listener );
     alphabetPanel.add(button);
}