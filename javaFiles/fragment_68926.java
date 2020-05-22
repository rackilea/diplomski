//frame.addButton(button); // <-- first instance created and added

frame.run();

// ˇ second instance created and added
frame.addButton(button).addActionListener(new ActionListener() {//Get JButton returned after calling function (I know it's crappy, but I could not find a way to do something similar) 9812934
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("sadasdasd");
    }
});