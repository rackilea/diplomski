String letters[] = {"0", "a", "b", "c", "d", "e", "f"};
JButton btn;
int count = 0;

HashMap<String,JButton> buttonCache = new HashMap<String,JButton>();


for (int f=1; f < 7;f++){

    for (int i=1; i < 7;i++){
        btn = new JButton(letters[f]+i, cup);
        mainGameWindow.add(btn[i]);
        btn.addActionListener(this);
        String stringCommand = Integer.toString(randomArrayNum());
        btn.setActionCommand(stringCommand);
        buttonMap.put(stringCommand,btn);
        count++;
        if(count == 18){
            generateArray();
        }

    }

}