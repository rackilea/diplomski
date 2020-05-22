vert.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent e) {
        ausgabe5.setText(""); 
        String[] test = eingabe3.getText().split("\\n"); 
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < test.length; i += 2) {
            for (int j = 0; j < test[i].length(); j++) {
                String hex = "" + test[i].charAt(j) + test[i + 1].charAt(j);
                output.append((char)Integer.parseInt(hex,16));
            }
        }
        System.out.println(output.toString());
    } 
});