String letters[] = {"0", "a", "b", "c", "d", "e", "f"};
int count = 0;

for (int f=1; f < 7;f++){
    for (int i=1; i < 7;i++) {
        String stringCommand = Integer.toString(randomArrayNum());
        Button btn = new JButton(letters[f]+i, cup);

        btn.setActionCommand(stringCommand);
        btn.addActionListener(this);
        mainGameWindow.add(btn[i]);

        // NOTE : I have no idea what this is for...
        count++;
        if(count == 18){
            generateArray();
        }
    }
}